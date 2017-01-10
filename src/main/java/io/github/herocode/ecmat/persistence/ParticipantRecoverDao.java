package io.github.herocode.ecmat.persistence;

import io.github.herocode.ecmat.entity.ParticipantRecover;
import io.github.herocode.ecmat.interfaces.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ParticipantRecoverDao implements Dao<ParticipantRecover, String> {

    @Deprecated
    @Override
    public boolean save(ParticipantRecover object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Deprecated
    @Override
    public boolean delete(ParticipantRecover object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ParticipantRecover object) {

        Connection connection;
        PreparedStatement preparedStatement;

        int result = 0;

        try {

            connection = ConnectionProvider.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("UPDATE " + getTableName() + " SET is_valid = ? WHERE token = ?");

            int count = 1;

            preparedStatement.setBoolean(count++, object.isValid());
            preparedStatement.setString(count++, object.getToken());

            result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }

        return result > 0;
    }

    public boolean needRecover(String email) {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        boolean response = false;

        try {

            String sql = "SELECT is_valid FROM " + getTableName() + " WHERE participant_email = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setString(count++, email);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                response = resultSet.getBoolean("is_valid");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }

        return response;
    }

    @Override
    public ParticipantRecover searchById(String token) {

        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        ParticipantRecover participantRecover = null;

        try {

            String sql = "SELECT * FROM " + getTableName() + " WHERE token = ?";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            statement.setString(count++, token);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                participantRecover = fillObject(resultSet);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }

        return participantRecover;
    }

    @Deprecated
    @Override
    public List<ParticipantRecover> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParticipantRecover fillObject(ResultSet rs) {

        ParticipantRecover pr = new ParticipantRecover();

        try {
            pr.setIsValid(rs.getBoolean("is_valid"));
            pr.setParticipantEmail(rs.getString("participant_email"));
            pr.setToken(rs.getString("token"));
        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }

        return pr;
    }

    @Override
    public String getTableName() {

        return "participant_recover";
    }

}
