/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.controller;

import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.interfaces.PaymentBusiness;
import io.github.herocode.ecmat.interfaces.PaymentChecker;
import io.github.herocode.ecmat.model.PaymentBusinessImpl;
import io.github.herocode.ecmat.model.PaymentCheckerImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class PaymentNotification extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String notificationCode = request.getParameter("notificationCode");
        
        PaymentChecker paymentChecker   = new PaymentCheckerImpl();
        PaymentBusiness paymentBusiness = new PaymentBusinessImpl();

        try {
            
            Map<String, String> paymentDetails = paymentChecker.checkPayment(notificationCode);
            
            String date             = paymentDetails.get("date");
            String lastEventDate    = paymentDetails.get("lastEventDate");
            
            DateTimeFormatter formartter = DateTimeFormatter.ofPattern("YYYY-MM-DDThh:mm:ss.sTZD");
            
            Payment payment = new Payment();
            payment.setCode(paymentDetails.get("code"));
            payment.setDate(LocalDateTime.parse(date, formartter));
            payment.setLastEventDate(LocalDateTime.parse(lastEventDate, formartter));
            payment.setReference(paymentDetails.get("reference"));
            payment.setStatus(paymentDetails.get("status"));
            
            paymentBusiness.update(payment);
            
        } catch (DOMException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(PaymentNotification.class.getName()).log(Level.SEVERE, null, ex);
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
