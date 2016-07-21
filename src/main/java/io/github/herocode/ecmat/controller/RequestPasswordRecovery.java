/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.controller;

import com.google.gson.Gson;
import io.github.herocode.ecmat.entity.PasswordResetRequest;
import io.github.herocode.ecmat.enums.EmailMessages;
import io.github.herocode.ecmat.model.EmailClient;
import io.github.herocode.ecmat.model.PasswordResetBusinessImpl;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import io.github.herocode.ecmat.interfaces.PasswordResetBusiness;

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

        String token = email.hashCode() + String.valueOf(localDateTime.hashCode());

        token = DigestUtils.md5Hex(token);

        String resetUrl = "http://www.ecmat.com.br/ResetPassword?token=" + token;

        PasswordResetRequest resetRequest = new PasswordResetRequest();
        resetRequest.setCreationDate(localDateTime);
        resetRequest.setIsValid(true);
        resetRequest.setToken(token);
        resetRequest.setParticipantEmail(email);

        PasswordResetBusiness resetPasswordBusiness = new PasswordResetBusinessImpl();

        resetPasswordBusiness.save(resetRequest);

        String emailMessage = EmailMessages.RECOVER_PASSWORD.getMessage() + "\n" + resetUrl;

        System.out.println("EMAIL: " + emailMessage);

        EmailClient.sendEmail("Ecmat - Resetar Senha", email, emailMessage, EmailClient.defaultSender, EmailClient.defaultPassword);

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("success", "Dentro de alguns minutos um E-mail será enviado com as instruções de recuperação.");

        String json = new Gson().toJson(responseMap);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
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
