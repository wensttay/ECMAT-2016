/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class EmailClient {

    public static String defaultSender = "devecmat2016@gmail.com";
    public static String defaultPassword = "devofecmat2016byherocode";

    public static void sendEmail(String subject, String receiver, String message, String sender, String password) {

        new Thread() {

            @Override
            public void run() {

                Properties props = new Properties();
                /**
                 * Parâmetros de conexão com servidor Gmail
                 */
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender, password);
                    }
                });

                session.setDebug(true);

                try {

                    Message msg = new MimeMessage(session);
                    msg.setContent(message, "text/plain; charset=UTF-8");
                    msg.setFrom(new InternetAddress(sender));

                    Address[] toUser = InternetAddress.parse(receiver);

                    msg.setRecipients(Message.RecipientType.TO, toUser);
                    msg.setSubject(subject);

                    Transport.send(msg);

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }

            }
            
        }.start();

    }

}
