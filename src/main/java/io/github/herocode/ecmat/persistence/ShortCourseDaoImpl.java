/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.persistence;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Phone;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.interfaces.ShortCourseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ShortCourseDaoImpl implements ShortCourseDao {

    @Override
    public boolean save(ShortCourse object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "INSERT INTO " + getTableName()
                    + "(max_enrollment, short_course_date, title, professor VALUES (?, ?, ?, ?)";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, object.getMaxEnrollment());
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getDate()));
            statement.setString(count++, object.getTitle());
            statement.setString(count++, object.getProfessor());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result != 0;
    }

    @Override
    public boolean delete(ShortCourse object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, object.getId());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result != 0;
    }

    @Override
    public boolean update(ShortCourse object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "UPDATE " + getTableName() + " SET "
                    + "max_enrollment = ?, short_course_date = ?, title = ?, professor = ?"
                    + " WHERE id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, object.getMaxEnrollment());
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getDate()));
            statement.setString(count++, object.getTitle());
            statement.setString(count++, object.getProfessor());
            statement.setInt(count++, object.getId());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result != 0;
    }

    @Override
    public ShortCourse searchById(Integer id) {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        ShortCourse shortCourse = null;

        try {

            String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                shortCourse = fillObject(resultSet);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return shortCourse;
    }

    @Override
    public List<ShortCourse> listAll() {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        List<ShortCourse> shortCourses = new ArrayList<>();

        try {

            String sql = "SELECT * FROM " + getTableName();

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                shortCourses.add(fillObject(resultSet));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return shortCourses;
    }

    @Override
    public ShortCourse fillObject(ResultSet rs) {

        ShortCourse shortCourse = null;

        try {

            shortCourse = new ShortCourse();

            shortCourse.setId(rs.getInt("id"));
            shortCourse.setDate(rs.getTimestamp("short_course_date").toLocalDateTime());
            shortCourse.setMaxEnrollment(rs.getInt("max_enrollment"));
            shortCourse.setProfessor(rs.getString("professor"));
            shortCourse.setTitle(rs.getString("title"));

        } catch (SQLException ex) {

        }

        return shortCourse;

    }

    @Override
    public String getTableName() {
        return "short_course";
    }

    @Override
    public List<Participant> getShortCourseParticipants(ShortCourse shortCourse) {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        List<Participant> participants = new ArrayList<>();

        try {

            String sql = "SELECT * FROM " + getRelationWithParticipantTableName() + " scp JOIN participant p ON scp.participant_id = p.id WHERE scp.short_course_id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, shortCourse.getId());

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                participants.add(fillParticipantObejct(resultSet));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return participants;
    }

    @Override
    public int getCurrentEnrollment(ShortCourse shortCourse) {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        int currentEnrollment = 999;

        try {

            String sql = "SELECT COUNT(*) AS quantity FROM " + getRelationWithParticipantTableName() + " scp JOIN participant p ON scp.participant_id = p.id WHERE  scp.short_course_id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, shortCourse.getId());

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                currentEnrollment = resultSet.getInt("quantity");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return currentEnrollment;
    }

    @Override
    public boolean removeParticipant(ShortCourse shortCourse, Participant participant) {

        Connection connection;
        PreparedStatement statement;

        int changes = 0;

        try {

            String sql = "DELETE FROM " + getRelationWithParticipantTableName() + " WHERE short_course_id = ? AND participant_id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, shortCourse.getId());
            statement.setInt(count++, participant.getId());

            changes = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return changes != 0;
    }

    @Override
    public boolean addParticipant(ShortCourse shortCourse, Participant participant) {

        Connection connection;
        PreparedStatement statement;

        int changes = 0;

        try {

            String sql = "INSERT INTO " + getRelationWithParticipantTableName() + " VALUES(?, ?)";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, shortCourse.getId());
            statement.setInt(count++, participant.getId());

            changes = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return changes != 0;
    }

    @Override
    public boolean isParticipantEnrolledToDate(Participant participant, LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isParticipantEnrolledInThisShortCourse(Participant participant, ShortCourse shortCourse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRelationWithParticipantTableName() {
        return "short_course_participant";
    }

    @Override
    public Participant fillParticipantObejct(ResultSet rs) {

        Participant participant = null;

        try {

            participant = new Participant();

            Address address = new Address();
            address.setCity(rs.getString("city"));
            address.setComplement("");
            address.setCountry(rs.getString("country"));
            address.setDistrict(rs.getString("district"));
            address.setNumber(rs.getString("house_number"));
            address.setPostalCode(rs.getString("postal_code"));
            address.setState(rs.getString("state"));
            address.setStreet(rs.getString("street"));

            Phone phone = new Phone();
            phone.setAreaCode(rs.getString("phone_ddd"));
            phone.setNumber(rs.getString("phone_number"));

            participant.setAddress(address);
            participant.setPhone(phone);

            participant.setBirthDate(rs.getDate("birth_date").toLocalDate());
            participant.setCpf(rs.getString("cpf"));
            participant.setEmail(rs.getString("email"));
            participant.setId(rs.getInt("id"));
            participant.setName(rs.getString("name"));
            participant.setPassword(rs.getString("password"));
            participant.setTitration(rs.getString("titration"));

        } catch (SQLException ex) {
        }

        return participant;
    }

}
