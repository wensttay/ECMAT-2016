/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.controller;

import io.github.herocode.ecmat.entity.PasswordResetRequest;
import io.github.herocode.ecmat.model.PasswordResetBusinessImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.github.herocode.ecmat.interfaces.PasswordResetBusiness;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
@WebServlet(name = "ResetPassword", urlPatterns = {"/ResetPassword"})
public class ResetPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = request.getParameter("token");

        if (token != null && !token.trim().isEmpty()) {
            System.out.println(token);
            PasswordResetBusiness resetBusiness = new PasswordResetBusinessImpl();

            try {

                PasswordResetRequest resetRequest = resetBusiness.searchRequestPasswordByToken(token);

                if (resetBusiness.isPasswordResetRequestValid(resetRequest)) {

                    request.setAttribute("is_valid", true);
                    request.setAttribute("token", token);
                } else {

                    if (resetRequest.isValid()) {
                        resetRequest.setIsValid(false);
                        resetBusiness.updatePasswordResetRequest(resetRequest);
                    }

                    request.setAttribute("is_valid", false);
                }

            } catch (IllegalArgumentException ex) {
            }

        } else {
            System.out.println("if");
            request.setAttribute("is_valid", false);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/redefinir.jsp");
        dispatcher.forward(request, response);

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
