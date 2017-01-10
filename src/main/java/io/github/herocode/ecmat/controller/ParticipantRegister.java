package io.github.herocode.ecmat.controller;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Phone;
import com.google.gson.Gson;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.enums.PaymentStatus;
import io.github.herocode.ecmat.interfaces.CheckoutCreator;
import io.github.herocode.ecmat.interfaces.ParticipantBusiness;
import io.github.herocode.ecmat.model.CheckoutCreatorImpl;
import io.github.herocode.ecmat.model.ParticipantBuilder;
import io.github.herocode.ecmat.model.ParticipantBusinessImpl;
import io.github.herocode.ecmat.persistence.PaymentDao;
import io.github.herocode.ecmat.utils.DateUtils;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
@WebServlet(name = "ParticipantRegister", urlPatterns = {"/ParticipantRegister"})
public class ParticipantRegister extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String birthDate = request.getParameter("birth-date");
        String titration = request.getParameter("titration");
        String cpf = request.getParameter("cpf");
        String ddd = request.getParameter("ddd");
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postal-code");
        String state = request.getParameter("state");

        try {

            LocalDate bDate = DateUtils.getLocalDateFromString(birthDate);

            Phone phone = new Phone(ddd, phoneNumber);
            Address address = new Address("BRA", state, city, district, postalCode, street, number, "");

            ParticipantBuilder participantBuilder = new ParticipantBuilder(cpf, email);
            participantBuilder.setName(name).
                    setTitration(titration).
                    setAddress(address).
                    setBirthDate(bDate).
                    setPassword(password).
                    setPhone(phone);

            Participant participant = participantBuilder.build();

            ParticipantBusiness participantBusiness = new ParticipantBusinessImpl();

            String paymentReference = String.valueOf(participant.getCpf().hashCode());

            Payment payment = new Payment(paymentReference);

            CheckoutCreator checkoutCreator = new CheckoutCreatorImpl();

            String checkoutUrl = checkoutCreator.buildCheckout(participant, paymentReference);

            payment.setUrl(new URL(checkoutUrl));
            payment.setStatus(PaymentStatus.AWAITING_PAYMENT.getCode());

            PaymentDao paymentDao = new PaymentDao();

            paymentDao.save(payment);

            participant = participantBusiness.saveParticipant(participant, paymentReference);

            request.getSession().setAttribute("participant", participant);
            response.sendRedirect("ParticipantPanel");

        } catch (Exception ex) {
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
