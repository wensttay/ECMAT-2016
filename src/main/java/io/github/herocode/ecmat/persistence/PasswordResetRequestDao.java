/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.persistence;

import io.github.herocode.ecmat.entity.PasswordResetRequest;
import io.github.herocode.ecmat.interfaces.Dao;
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
public class PasswordResetRequestDao implements Dao<PasswordResetRequest, Integer> {

    @Override
    public boolean save(PasswordResetRequest object) {

        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "INSERT INTO " + getTableName() + " (token, is_valid, creation_date, participant_email) VALUES (?, ?, ?, ?)";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setString(count++, object.getToken());
            statement.setBoolean(count++, object.isValid());
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(object.getCreationDate()));
            statement.setString(count++, object.getParticipantEmail());
            
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result != 0;
    }

    @Override
    public boolean delete(PasswordResetRequest object) {

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
    public boolean update(PasswordResetRequest object) {
        
        Connection connection;
        PreparedStatement statement;

        int result = 0;

        try {

            String sql = "UPDATE " + getTableName() + " SET is_valid = ? WHERE id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setBoolean(count++, object.isValid());
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
    public PasswordResetRequest searchById(Integer id) {
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        PasswordResetRequest resetRequest = null;

        try {

            String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setInt(count++, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resetRequest = fillObject(resultSet);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resetRequest;
    }

    @Override
    public List<PasswordResetRequest> listAll() {
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        List<PasswordResetRequest> resetRequests = new ArrayList<>(); 

        try {

            String sql = "SELECT * FROM " + getTableName();

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resetRequests.add(fillObject(resultSet));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resetRequests;
    }

    @Override
    public PasswordResetRequest fillObject(ResultSet rs) {
        
        PasswordResetRequest resetRequest = null;

        try {
            resetRequest = new PasswordResetRequest();
            resetRequest.setId(rs.getInt("id"));
            resetRequest.setIsValid(rs.getBoolean("is_valid"));
            resetRequest.setToken(rs.getString("token"));
            resetRequest.setCreationDate(rs.getTimestamp("creation_date").toLocalDateTime());
            resetRequest.setParticipantEmail(rs.getString("participant_email"));
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resetRequest;
    }

    @Override
    public String getTableName() {
        return "password_reset_request";
    }

}
