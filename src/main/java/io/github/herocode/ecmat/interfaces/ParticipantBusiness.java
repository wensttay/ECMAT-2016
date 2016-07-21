/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.Payment;
import io.github.herocode.ecmat.entity.ShortCourse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface ParticipantBusiness {

    boolean saveParticipant(Participant participant, String paymentId);
    
    boolean saveParticipant(Participant participant, Payment payment);

    boolean updateParticipant(Participant participant);

    boolean deleteParticipant(Participant participant);

    List<Participant> listAllParticipants();

    Participant searchParticipantById(int id) throws IllegalArgumentException;
    
    Participant login(String email, String password) throws IllegalArgumentException;
    
    Participant searchParticipantByEmail(String email) throws IllegalArgumentException;
    
    List<ShortCourse> getRegisteredShortCourse(Participant participant);
    
    List<Participant> searchParticipantByAttribute(String key, String value);
    
    List<Participant> searchParticipantByAttributes(Map<String, String> map);
    
}
