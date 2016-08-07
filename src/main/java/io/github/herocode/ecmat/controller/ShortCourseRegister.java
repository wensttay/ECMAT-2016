/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.controller;

import com.google.gson.Gson;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.exceptions.EnrollingShortCourseException;
import io.github.herocode.ecmat.interfaces.ShortCourseBusiness;
import io.github.herocode.ecmat.model.ShortCourseBusinessImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wensttay
 */
@WebServlet(name = "ShortCourseRegister", urlPatterns = {"/ShortCourseRegister"})
public class ShortCourseRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ShortCourseBusiness shortCourseBusiness = ShortCourseBusinessImpl.getInstance();
        Integer shortCourseId                   = Integer.parseInt(request.getParameter("ShortCourseId"));
        Participant participant                 = (Participant) request.getSession().getAttribute("participant");
        ShortCourse shortCourse                 = null;

        try {
            
            shortCourse = shortCourseBusiness.searchShortCourseById(shortCourseId);

            if (shortCourse != null && participant != null) {
                shortCourseBusiness.addParticipantInShortCourse(shortCourse, participant);
            }

            response.sendRedirect("/painel.jsp");
            
        } catch (EnrollingShortCourseException ex) {

            System.err.println(ex);
            ex.printStackTrace();

            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("error", ex.getMessage());

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
     *
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
     *
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
