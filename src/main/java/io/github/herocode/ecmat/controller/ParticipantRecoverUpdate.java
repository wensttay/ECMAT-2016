package io.github.herocode.ecmat.controller;

import br.com.uol.pagseguro.domain.Phone;
import com.google.gson.Gson;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ParticipantRecover;
import io.github.herocode.ecmat.enums.ErrorMessages;
import io.github.herocode.ecmat.interfaces.ParticipantBusiness;
import io.github.herocode.ecmat.model.ParticipantBusinessImpl;
import io.github.herocode.ecmat.model.ParticipantValidator;
import io.github.herocode.ecmat.persistence.ParticipantRecoverDao;
import io.github.herocode.ecmat.utils.DateUtils;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
@WebServlet(name = "ParticipantRecoverUpdate", urlPatterns = {"/ParticipantRecoverUpdate"})
public class ParticipantRecoverUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String birthDate = request.getParameter("birth-date");
        String titration = request.getParameter("titration");
        String ddd = request.getParameter("ddd");
        String phoneNumber = request.getParameter("phone");
        String password = request.getParameter("password");

        String token = request.getParameter("token");
        String error = "";

        if (token != null && !token.trim().isEmpty()) {

            ParticipantRecoverDao recoverDao = new ParticipantRecoverDao();

            ParticipantRecover participantRecover = recoverDao.searchById(token);

            if (participantRecover.isValid()) {

                LocalDate bDate = DateUtils.getLocalDateFromString(birthDate);

                Phone phone = new Phone(ddd, phoneNumber);

                ParticipantBusiness participantBusiness = new ParticipantBusinessImpl();
                Participant participant = participantBusiness.searchParticipantByEmail(participantRecover.getParticipantEmail());

                participant.setName(name);
                participant.setBirthDate(bDate);
                participant.setTitration(titration);
                participant.setPhone(phone);
                participant.setPassword(password);

                try {

                    ParticipantValidator.validateParticipant(participant);
                    participant.setPassword(DigestUtils.sha1Hex(password));

                    participantBusiness.updateParticipant(participant);

                    participantRecover.setIsValid(false);
                    recoverDao.update(participantRecover);

                } catch (IllegalArgumentException ex) {

                    error = ex.getMessage();
                }

            } else {

                error = ErrorMessages.INVALID_TOKEN.getErrorMessage() + " , ele ja foi utilizado.";
            }

        } else {

            error = ErrorMessages.INVALID_TOKEN.getErrorMessage() + " , nenhum token Informado.";
        }

        if (!error.trim().isEmpty()) {

            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("error", error);

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
