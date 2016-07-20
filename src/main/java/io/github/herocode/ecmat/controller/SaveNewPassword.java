/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.controller;

import com.google.gson.Gson;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.PasswordResetRequest;
import io.github.herocode.ecmat.enums.ErrorMessages;
import io.github.herocode.ecmat.interfaces.ParticipantBusiness;
import io.github.herocode.ecmat.model.PasswordResetBusinessImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import io.github.herocode.ecmat.interfaces.PasswordResetBusiness;
import io.github.herocode.ecmat.model.ParticipantBusinessImpl;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
@WebServlet(name = "SaveNewPassword", urlPatterns = {"/SaveNewPassword"})
public class SaveNewPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = request.getParameter("token");
        System.out.println("entrei");
        System.out.println(token);

        if (token != null && !token.trim().isEmpty()) {

            PasswordResetBusiness resetBusiness = new PasswordResetBusinessImpl();
            System.out.println("token n nulo");
            try {

                PasswordResetRequest resetRequest = resetBusiness.searchRequestPasswordByToken(token);

                if (resetBusiness.isPasswordResetRequestValid(resetRequest)) {

                    String email = resetRequest.getParticipantEmail();

                    String password = request.getParameter("password");
                    String passwordConfirm = request.getParameter("password-confirm");

                    if (!password.equals(passwordConfirm)) {

                        Map<String, String> responseMap = new HashMap<>();
                        responseMap.put("error", ErrorMessages.DIFFERENT_PASSWORDS.getErrorMessage());

                        String json = new Gson().toJson(responseMap);

                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(json);

                    } else {

                        ParticipantBusiness participantBusiness = new ParticipantBusinessImpl();

                        try {

                            Participant participant = participantBusiness.searchParticipantByEmail(email);
                            participant.setPassword(DigestUtils.sha1Hex(password));

                            participantBusiness.updateParticipant(participant);

                            resetRequest.setIsValid(false);

                            resetBusiness.updatePasswordResetRequest(resetRequest);

                        } catch (IllegalArgumentException ex) {
                            
                        }

                    }

                    //terminar, tem que redireionar para a pag que o boy vai digitar a senha
                } else {

                    if (resetRequest.isValid()) {
                        resetRequest.setIsValid(false);
                        resetBusiness.updatePasswordResetRequest(resetRequest);
                    }

                    Map<String, String> responseMap = new HashMap<>();
                    responseMap.put("error", ErrorMessages.INVALID_TOKEN.getErrorMessage());

                    String json = new Gson().toJson(responseMap);

                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                }

            } catch (IllegalArgumentException ex) {
            }

        } else {
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("error", ErrorMessages.INVALID_TOKEN.getErrorMessage());

            String json = new Gson().toJson(responseMap);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }

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
