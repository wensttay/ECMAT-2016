/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.controller;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Phone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.PasswordResetRequest;
import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.enums.EmailMessages;
import io.github.herocode.ecmat.enums.PaymentStatus;
import io.github.herocode.ecmat.interfaces.CheckoutCreator;
import io.github.herocode.ecmat.interfaces.Dao;
import io.github.herocode.ecmat.interfaces.ParticipantDao;
import io.github.herocode.ecmat.interfaces.PaymentBusiness;
import io.github.herocode.ecmat.interfaces.PaymentChecker;
import io.github.herocode.ecmat.model.CheckoutCreatorImpl;
import io.github.herocode.ecmat.model.EmailClient;
import io.github.herocode.ecmat.model.ParticipantBuilder;
import io.github.herocode.ecmat.model.PaymentBusinessImpl;
import io.github.herocode.ecmat.model.PaymentCheckerImpl;
import io.github.herocode.ecmat.model.PasswordResetBusinessImpl;
import io.github.herocode.ecmat.persistence.ParticipantDaoImpl;
import io.github.herocode.ecmat.persistence.PasswordResetRequestDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateStringConverter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.digester.Digester;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import io.github.herocode.ecmat.interfaces.PasswordResetBusiness;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
@WebServlet(name = "RequestPasswordRecovery", urlPatterns = {"/RequestPasswordRecovery"})
public class RequestPasswordRecovery extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        
        String token = email.hashCode()+String.valueOf(localDateTime.hashCode());
        
        token = DigestUtils.md5Hex(token);
        
        String resetUrl = "http://www.ecmat.com.br/ResetPassword?token="+token;
        
        PasswordResetRequest resetRequest = new PasswordResetRequest();
        resetRequest.setCreationDate(localDateTime);
        resetRequest.setIsValid(true);
        resetRequest.setToken(token);
        resetRequest.setParticipantEmail(email);
        
        PasswordResetBusiness resetPasswordBusiness = new PasswordResetBusinessImpl();
        
        resetPasswordBusiness.save(resetRequest);
        
        String emailMessage = EmailMessages.RECOVER_PASSWORD.getMessage() + "\n" + resetUrl;
        
        System.out.println("EMAIL: "+emailMessage);
        
        EmailClient.sendEmail("Ecmat - Resetar Senha", email, emailMessage, EmailClient.defaultSender, EmailClient.defaultPassword);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
