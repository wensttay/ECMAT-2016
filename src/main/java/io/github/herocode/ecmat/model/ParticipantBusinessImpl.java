/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.enums.ErrorMessages;
import io.github.herocode.ecmat.interfaces.ParticipantBusiness;
import io.github.herocode.ecmat.interfaces.ParticipantDao;
import io.github.herocode.ecmat.persistence.ParticipantDaoImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ParticipantBusinessImpl implements ParticipantBusiness {

    private ParticipantDao dao;

    public ParticipantBusinessImpl() {
        this.dao = new ParticipantDaoImpl();
    }

    @Override
    public boolean saveParticipant(Participant participant, String paymentId) {

        return dao.save(participant, paymentId);
    }

    @Override
    public boolean updateParticipant(Participant participant) {

        return dao.update(participant);
    }

    @Override
    public boolean deleteParticipant(Participant participant) {

        return dao.delete(participant);
    }

    @Override
    public Participant searchParticipantById(int id) throws IllegalArgumentException {

        Participant participant = dao.searchById(id);

        if (participant == null) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ID.getErrorMessage());
        }

        return participant;
    }

    @Override
    public List<ShortCourse> getRegisteredShortCourse(Participant participant) {

        return Collections.unmodifiableList(dao.getRegisteredShortCourse(participant));
    }

    @Override
    public List<Participant> listAllParticipants() {

        return Collections.unmodifiableList(dao.listAll());
    }

    @Override
    public List<Participant> searchParticipantByAttribute(String key, String value) {

        return Collections.unmodifiableList(dao.searchByAttribute(key, value));
    }

    @Override
    public List<Participant> searchParticipantByAttributes(Map<String, String> map) {

        return Collections.unmodifiableList(dao.searchByAttributes(map));
    }

    @Override
    public Participant searchParticipantByEmail(String email) throws IllegalArgumentException {

        try {

            Participant participant = searchParticipantByAttribute("email", email).get(0);
            return participant;
        } catch (Exception ex) {
            System.err.println("Email invalido - "+email);
            throw new IllegalArgumentException(ErrorMessages.INVALID_EMAIL.getErrorMessage());

        }

    }

    @Override
    public Participant login(String email, String password) throws IllegalArgumentException {
        
        Map<String,String> map = new HashMap<>();
        
        map.put("email", email);
        map.put("password", password);
        
        List<Participant> participants = searchParticipantByAttributes(map);
        
        if(participants.isEmpty()){
            throw new IllegalArgumentException(ErrorMessages.FAIL_LOGIN.getErrorMessage());
        }
        
        return participants.get(0);
    }

    @Override
    public boolean saveParticipant(Participant participant, Payment payment) {
        
        return dao.save(participant, payment);
    }

    @Override
    public String getEmailFromPaymentReference(String paymentReference) {
        
        return dao.getEmailFromPaymentReference(paymentReference);
    }

}
