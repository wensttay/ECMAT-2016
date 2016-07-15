/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.persistence;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Phone;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.interfaces.Dao;
import io.github.herocode.ecmat.interfaces.ParticipantDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ParticipantDaoImpl implements ParticipantDao {

    @Override
    public List<ShortCourse> getRegisteredShortCourse(Participant participant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Participant participant, Payment payment) {
        
        save(participant);
        
        if (payment != null) {
            
            Dao<Payment, String> paymentDao = new PaymentDao();
            return paymentDao.save(payment);
        }
        
        return false;
    }

    @Override
    public boolean save(Participant object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "INSERT INTO " + getTableName() + " (id, "
                    + "name, birth_date, phone_ddd, phone_number, titration, cpf,"
                    + " email, password, country, state, city, district, postal_code,"
                    + " street, house_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,"
                    + "?, ?, ?, ?, ?)";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, object.getId());
            statement.setString(count++, object.getName());
            statement.setDate(count++, java.sql.Date.valueOf(object.getBirthDate()));
            statement.setString(count++, object.getPhone().getAreaCode());
            statement.setString(count++, object.getPhone().getNumber());
            statement.setString(count++, object.getTitration());
            statement.setString(count++, object.getCpf());
            statement.setString(count++, object.getEmail());
            statement.setString(count++, object.getPassword());
            statement.setString(count++, object.getAddress().getCountry());
            statement.setString(count++, object.getAddress().getState());
            statement.setString(count++, object.getAddress().getCity());
            statement.setString(count++, object.getAddress().getDistrict());
            statement.setString(count++, object.getAddress().getPostalCode());
            statement.setString(count++, object.getAddress().getStreet());
            statement.setString(count++, object.getAddress().getNumber());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result != 0;
    }

    @Override
    public boolean delete(Participant object) {

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
    public boolean update(Participant object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "UPDATE " + getTableName() + " SET payment_id = ?, "
                    + "name = ?, birth_date = ?, phone_ddd = ?, phone_number = ?,"
                    + " titration = ?, cpf = ?, email = ?, password = ?, country = ?,"
                    + " state = ?, city = ?, district = ?, postal_code = ?,"
                    + " street = ?, number = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setString(count++, object.getPayment().getReference());
            statement.setString(count++, object.getName());
            statement.setDate(count++, java.sql.Date.valueOf(object.getBirthDate()));
            statement.setString(count++, object.getPhone().getAreaCode());
            statement.setString(count++, object.getPhone().getNumber());
            statement.setString(count++, object.getTitration());
            statement.setString(count++, object.getCpf());
            statement.setString(count++, object.getEmail());
            statement.setString(count++, object.getPassword());
            statement.setString(count++, object.getAddress().getCountry());
            statement.setString(count++, object.getAddress().getState());
            statement.setString(count++, object.getAddress().getCity());
            statement.setString(count++, object.getAddress().getDistrict());
            statement.setString(count++, object.getAddress().getPostalCode());
            statement.setString(count++, object.getAddress().getStreet());
            statement.setString(count++, object.getAddress().getNumber());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result != 0;
    }

    @Override
    public Participant searchById(Integer id) {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        Participant participant = null;

        try {

            String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                participant = fillObject(resultSet);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return participant;
    }

    @Override
    public List<Participant> listAll() {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        List<Participant> participants = new ArrayList<>();

        try {

            String sql = "SELECT * FROM " + getTableName();

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                participants.add(fillObject(resultSet));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return participants;
    }

    @Override
    public Participant fillObject(ResultSet rs) {

        Participant participant = null;

        try {
            System.out.println("preenchendo...");
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
            System.out.println("foi o address");
            Phone phone = new Phone();
            phone.setAreaCode("phone_ddd");
            phone.setNumber(rs.getString("phone_number"));

            participant.setAddress(address);
            participant.setPhone(phone);
            System.out.println("foi o phone");
            participant.setBirthDate(rs.getDate("birth_date").toLocalDate());
            participant.setCpf(rs.getString("cpf"));
            participant.setEmail(rs.getString("email"));
            participant.setId(rs.getInt("id"));
            participant.setName(rs.getString("name"));
            participant.setPassword(rs.getString("password"));
            participant.setTitration(rs.getString("titration"));
            System.out.println("concluido");
        } catch (SQLException ex) {
        }

        return participant;
    }

    @Override
    public String getTableName() {

        return "participant";
    }

}
