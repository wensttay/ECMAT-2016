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
import io.github.herocode.ecmat.enums.ShortCourseType;
import io.github.herocode.ecmat.interfaces.ShortCourseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

            StringBuilder sql = new StringBuilder("INSERT INTO ").
                    append(getTableName()).
                    append("(max_enrollment, short_course_start_date, short_course_end_date, ").
                    append("title, description, professor, place, type, equipment_needed) ").
                    append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

            int count = 1;

            statement.setInt(count++, object.getMaxEnrollment());
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getStartDate()));
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getEndDate()));
            statement.setString(count++, object.getTitle());
            statement.setString(count++, object.getDescription());
            statement.setString(count++, object.getProfessor());
            statement.setString(count++, object.getPlace());
            statement.setString(count++, object.getShortCourseType().getTypeName());
            statement.setString(count++, object.getEquipmentNeeded());

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

            StringBuilder sql = new StringBuilder("DELETE FROM ").
                    append(getTableName()).
                    append(" WHERE id = ?");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

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

            StringBuilder sql = new StringBuilder("UPDATE ").append(getTableName()).
                    append(" SET max_enrollment = ?, short_course_start_date = ?, ").
                    append("short_course_end_date = ?, title = ?, description = ?, professor = ?, ").
                    append("place = ?, type = ?, equipment_needed = ? WHERE id = ?");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

            int count = 1;

            statement.setInt(count++, object.getMaxEnrollment());
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getStartDate()));
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getEndDate()));
            statement.setString(count++, object.getTitle());
            statement.setString(count++, object.getDescription());
            statement.setString(count++, object.getProfessor());
            statement.setString(count++, object.getPlace());
            statement.setString(count++, object.getShortCourseType().getTypeName());
            statement.setString(count++, object.getEquipmentNeeded());
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

            StringBuilder sql = new StringBuilder("SELECT * FROM ").
                    append(getTableName()).
                    append(" WHERE id = ?");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

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

            StringBuilder sql = new StringBuilder("SELECT * FROM ").append(getTableName());

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

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
            shortCourse.setMaxEnrollment(rs.getInt("max_enrollment"));
            shortCourse.setStartDate(rs.getTimestamp("short_course_start_date").toLocalDateTime());
            shortCourse.setEndDate(rs.getTimestamp("short_course_end_date").toLocalDateTime());
            shortCourse.setTitle(rs.getString("title"));
            shortCourse.setDescription(rs.getString("description"));
            shortCourse.setProfessor(rs.getString("professor"));
            shortCourse.setPlace(rs.getString("place"));
            shortCourse.setShortCourseType(ShortCourseType.valueOf(rs.getString("type")));
            shortCourse.setEquipmentNeeded(rs.getString("equipment_needed"));

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

            StringBuilder sql = new StringBuilder("SELECT * FROM ").
                    append(getRelationWithParticipantTableName()).
                    append(" scp JOIN participant p ON scp.participant_id = p.id").
                    append(" WHERE scp.short_course_id = ?");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

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

        int currentEnrollment = -1;

        try {

            StringBuilder sql = new StringBuilder("SELECT COUNT(*) AS quantity FROM ").
                    append(getRelationWithParticipantTableName()).
                    append(" scp JOIN participant p ON scp.participant_id = p.id WHERE").
                    append(" scp.short_course_id = ?");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

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

            StringBuilder sql = new StringBuilder("DELETE FROM ").
                    append(getRelationWithParticipantTableName()).
                    append(" WHERE short_course_id = ? AND participant_id = ?");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

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

            StringBuilder sql = new StringBuilder("INSERT INTO ").
                    append(getRelationWithParticipantTableName()).append(" VALUES(?, ?)");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

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

    @Override
    public List<ShortCourse> getParticipantShortCourses(Participant participant) {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        List<ShortCourse> shortCourses = new ArrayList<>();

        try {

            StringBuilder sql = new StringBuilder("SELECT * FROM ").
                    append(getRelationWithParticipantTableName()).
                    append(" scp JOIN ").
                    append(getTableName()).
                    append(" sc ON scp.short_course_id = sc.id ").
                    append(" WHERE scp.participant_id = ?");

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql.toString());

            int count = 1;

            statement.setInt(count++, participant.getId());

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
    public Map<Integer, Integer> getShortcoursersCurrentEnrollments() {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        Map<Integer, Integer> currentEnrollments = new HashMap<>();

        try {

            String sql = "SELECT COUNT\n"
                    + " (*) AS current_erollment, s.id\n"
                    + " AS short_course_id FROM short_course_participant scp JOIN short_course s ON scp.short_course_id = s.id GROUP BY (s.id)";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                currentEnrollments.put(resultSet.getInt("short_course_id"), resultSet.getInt("current_erollment"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }

        return currentEnrollments;
    }

}
