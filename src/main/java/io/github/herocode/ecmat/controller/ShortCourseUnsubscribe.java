package io.github.herocode.ecmat.controller;

import com.google.gson.Gson;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.enums.ErrorMessages;
import io.github.herocode.ecmat.exceptions.EnrollingShortCourseException;
import io.github.herocode.ecmat.interfaces.ParticipantBusiness;
import io.github.herocode.ecmat.interfaces.ShortCourseBusiness;
import io.github.herocode.ecmat.model.ParticipantBusinessImpl;
import io.github.herocode.ecmat.model.ShortCourseBusinessImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "ShortCourseUnsubscribe", urlPatterns = {"/ShortCourseUnsubscribe"})
public class ShortCourseUnsubscribe extends HttpServlet {

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
        ParticipantBusiness participantBusiness = new ParticipantBusinessImpl();

        Integer shortCourseId = Integer.parseInt(request.getParameter("ShortCourseId"));
        Participant participant = (Participant) request.getSession().getAttribute("participant");

        if (participant != null) {
            participant = participantBusiness.searchParticipantById(participant.getId());
        }

        ShortCourse shortCourse = null;

        Map<String, String> responseMap = new HashMap<>();
        try {

            //Verify if Participant is not null
            if (participant == null) {
                throw new EnrollingShortCourseException(ErrorMessages.DESLOGED_ACCOUNT.getErrorMessage());
            }

            shortCourse = shortCourseBusiness.searchShortCourseById(shortCourseId);

            if (shortCourse != null && participant != null) {
                if (!shortCourseBusiness.removeParticipantFromShortCourse(shortCourse, participant)) {
                    throw new EnrollingShortCourseException(ErrorMessages.UNKNOW_ERROR.getErrorMessage());
                }
            }

            responseMap.put("success", "Sua inscrição no minicurso/oficina foi cancelada com sucesso </br>"
                    + "Agora você pode optar por outro do mesmo periodo, mas seja rápido!");

            String json = new Gson().toJson(responseMap);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        } catch (EnrollingShortCourseException ex) {

            System.err.println(ex);
            ex.printStackTrace();

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
