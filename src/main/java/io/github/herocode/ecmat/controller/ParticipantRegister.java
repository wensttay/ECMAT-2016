/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.controller;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Phone;
import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.interfaces.PaymentBusiness;
import io.github.herocode.ecmat.interfaces.PaymentChecker;
import io.github.herocode.ecmat.model.ParticipantBuilder;
import io.github.herocode.ecmat.model.PaymentBusinessImpl;
import io.github.herocode.ecmat.model.PaymentCheckerImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
@WebServlet(name = "PaymentNotification", urlPatterns = {"/PaymentNotification"})
public class ParticipantRegister extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name         = request.getParameter("name");
        String birthDate    = request.getParameter("birth-date");
        String titration    = request.getParameter("titration");
        String cpf          = request.getParameter("cpf");
        String ddd          = request.getParameter("ddd");
        String phoneNumber  = request.getParameter("phone");
        String email        = request.getParameter("email");
        String password     = request.getParameter("password");
        String street       = request.getParameter("street");
        String number       = request.getParameter("number");
        String district     = request.getParameter("district");
        String city         = request.getParameter("city");
        String postalCode   = request.getParameter("postal-code");
        String state        = request.getParameter("state");
        String country      = request.getParameter("country");

        Phone phone     = new Phone(ddd, phoneNumber);
        Address address = new Address(country, state, city, district, postalCode, street, number, street);
        
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
