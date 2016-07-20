/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.entity;

import io.github.herocode.ecmat.persistence.ConnectionProvider;
import io.github.herocode.ecmat.persistence.PaymentDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class PaymentNotificationExceptionLog {

    private LocalDateTime date;
    private String occurrence;
    private String stackTrace;
    private String notificationCode;

    public PaymentNotificationExceptionLog() {
    }

    public PaymentNotificationExceptionLog(LocalDateTime date, String occurrence, String stackTrace, String notificationCode) {
        this.date = date;
        this.occurrence = occurrence;
        this.stackTrace = stackTrace;
        this.notificationCode = notificationCode;
    }
    
    public LocalDateTime getDateTime() {
        return date;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public String getNotificationCode() {
        return notificationCode;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.date = dateTime;
    }

    public void setOccurrence(String occurrence) {
        this.occurrence = occurrence;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public void setNotifizcationCode(String notificationCode) {
        this.notificationCode = notificationCode;
    }
    
    public void saveLog(){
        
        Connection connection;
        PreparedStatement statement;

        try {

            String sql = "INSERT INTO payment_log (occurrence_date, occurrence, stack_trace, notification_code) VALUES (?, ?, ?, ?)";

            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareCall(sql);

            int count = 1;

            java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
            
            statement.setTimestamp(count++, java.sql.Timestamp.valueOf(date));
            statement.setString(count++, occurrence);
            statement.setString(count++, stackTrace);
            statement.setString(count++, notificationCode);

            statement.executeUpdate();

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
