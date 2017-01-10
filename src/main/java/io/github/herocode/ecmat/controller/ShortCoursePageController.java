package io.github.herocode.ecmat.controller;

import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.entity.ShortCourseItemView;
import io.github.herocode.ecmat.model.ShortCourseBusinessImpl;
import io.github.herocode.ecmat.persistence.ShortCourseDaoImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @version 3.1
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 08/01/2017 - 12:01:31
 */
@WebServlet(name = "Minicursos", urlPatterns = {"/Minicursos"})
public class ShortCoursePageController extends HttpServlet {

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

        List<ShortCourseItemView> morningShortCourseItems = new ArrayList<>();
        List<ShortCourseItemView> aftermoonShortCourseItems = new ArrayList<>();
        List<ShortCourseItemView> nightShortCourseItems = new ArrayList<>();

        ShortCourseBusinessImpl shortCourseBusinessImpl = ShortCourseBusinessImpl.getInstance();

        Participant participant = (Participant) request.getSession().getAttribute("participant");

        ShortCourseDaoImpl courseDaoImpl = new ShortCourseDaoImpl();
        List<ShortCourse> allCoursesAddedList = new ArrayList<>();

        if (participant != null) {
            allCoursesAddedList.addAll(courseDaoImpl.getParticipantShortCourses(participant));
        }

        List<ShortCourse> courses = shortCourseBusinessImpl.listAllShortCourse();

        for (ShortCourse course : courses) {
            boolean registred = allCoursesAddedList.contains(course);
            int currentEnrollment = courseDaoImpl.getCurrentEnrollment(course);

            switch (course.getShortCourseWorkShift()) {
                case MORNING:
                    morningShortCourseItems.add(new ShortCourseItemView(course, registred, currentEnrollment));
                    break;
                case AFTERNOON:
                    aftermoonShortCourseItems.add(new ShortCourseItemView(course, registred, currentEnrollment));
                    break;
                case NIGHT:
                    nightShortCourseItems.add(new ShortCourseItemView(course, registred, currentEnrollment));
                    break;
                default:
                    break;
            }
        }

//        morningShortCourseItems.add(new ShortCourseItemView(1, 30, "4h", "Um Show de Marionete", "www.google.com.br", ShortCourseType.SHORTCOURCE, ShortCourseWorkShift.MORNING, true));
//        morningShortCourseItems.add(new ShortCourseItemView(2, 20, "3h", "Festinha", "www.google.com.br", ShortCourseType.WORKSHOP, ShortCourseWorkShift.MORNING, false));
//        
//        aftermoonShortCourseItems.add(new ShortCourseItemView(1, 30, "4h", "Um Show da Tarde", "www.google.com.br", ShortCourseType.SHORTCOURCE, ShortCourseWorkShift.AFTERNOON, true));
//        aftermoonShortCourseItems.add(new ShortCourseItemView(2, 20, "3h", "Festinha da Tarde", "www.google.com.br", ShortCourseType.WORKSHOP, ShortCourseWorkShift.AFTERNOON, false));
//        
//        nightShortCourseItems.add(new ShortCourseItemView(1, 30, "4h", "Um Show da Noite", "www.google.com.br", ShortCourseType.SHORTCOURCE, ShortCourseWorkShift.NIGHT, true));
//        nightShortCourseItems.add(new ShortCourseItemView(2, 20, "3h", "Festinha da Noite", "www.google.com.br", ShortCourseType.WORKSHOP, ShortCourseWorkShift.NIGHT, false));
        Collections.sort(morningShortCourseItems);
        Collections.sort(aftermoonShortCourseItems);
        Collections.sort(nightShortCourseItems);

        request.setAttribute("morningShortCourseItems", morningShortCourseItems);
        request.setAttribute("aftermoonShortCourseItems", aftermoonShortCourseItems);
        request.setAttribute("nightShortCourseItems", nightShortCourseItems);

        RequestDispatcher rd = request.getSession().
                getServletContext().
                getRequestDispatcher("/courses.jsp");
        rd.forward(request, response);
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
