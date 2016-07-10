/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.persistence;

import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.interfaces.Dao;
import java.net.MalformedURLException;
import java.net.URL;
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
public class PaymentDao implements Dao<Payment, String> {

    @Override
    public boolean save(Payment object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "INSERT INTO " + getTableName() + " (date, lastEventDate, code, reference, status, url) VALUES ?, ?, ?, ?, ?, ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setDate(count++, java.sql.Date.valueOf(object.getDate()));
            statement.setDate(count++, java.sql.Date.valueOf(object.getLastEventDate()));
            statement.setString(count++, object.getCode());
            statement.setString(count++, object.getReference());
            statement.setString(count++, object.getStatus());
            statement.setString(count++, object.getUrl().toString());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
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

            String sql = "UPDATE " + getTableName() + " SET date = ?, lastEventDate = ?, code = ?, status = ? WHERE reference = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setDate(count++, java.sql.Date.valueOf(object.getDate()));
            statement.setDate(count++, java.sql.Date.valueOf(object.getLastEventDate()));
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
            payment.setDate(rs.getDate("date").toLocalDate());
            payment.setLastEventDate(rs.getDate("lastEventDate").toLocalDate());
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
