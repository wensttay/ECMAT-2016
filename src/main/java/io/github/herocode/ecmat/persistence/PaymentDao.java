package io.github.herocode.ecmat.persistence;

import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.interfaces.Dao;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class PaymentDao implements Dao<Payment, String> {

    @Override
    public boolean save(Payment object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "INSERT INTO " + getTableName() + " (date, last_event_date, reference, status, url) VALUES (?, ?, ?, ?, ?)";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;
            LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
            java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(now);

            statement.setTimestamp(count++, timestamp);
            statement.setTimestamp(count++, timestamp);
            statement.setString(count++, object.getReference());
            statement.setString(count++, object.getStatus());
            statement.setString(count++, object.getUrl().toString());

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
    public boolean delete(Payment object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "DELETE FROM " + getTableName() + " WHERE reference = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setString(count++, object.getReference());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result != 0;
    }

    @Override
    public boolean update(Payment object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "UPDATE " + getTableName() + " SET date = ?, last_event_date = ?, code = ?, status = ? WHERE reference = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getDate()));
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getLastEventDate()));
            statement.setString(count++, object.getCode());
            statement.setString(count++, object.getStatus());
            statement.setString(count++, object.getReference());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result != 0;
    }

    @Override
    public Payment searchById(String id) {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        Payment payment = null;

        try {

            String sql = "SELECT * FROM " + getTableName() + " WHERE reference = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setString(count++, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                payment = fillObject(resultSet);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return payment;
    }

    @Override
    public List<Payment> listAll() {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        List<Payment> payments = new ArrayList<>();

        try {

            String sql = "SELECT * FROM " + getTableName();

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                payments.add(fillObject(resultSet));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return payments;
    }

    @Override
    public Payment fillObject(ResultSet rs) {

        Payment payment = null;

        try {
            payment = new Payment();
            payment.setCode(rs.getString("code"));
            payment.setDate(rs.getTimestamp("date").toLocalDateTime());
            payment.setLastEventDate(rs.getTimestamp("last_event_date").toLocalDateTime());
            payment.setReference(rs.getString("reference"));
            payment.setStatus(rs.getString("status"));
            payment.setUrl(new URL(rs.getString("url")));
        } catch (SQLException | MalformedURLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return payment;
    }

    @Override
    public String getTableName() {
        return "payment";
    }

}
