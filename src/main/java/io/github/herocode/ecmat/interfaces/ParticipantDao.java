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

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface ParticipantDao extends Dao<Participant, Integer> {

    List<ShortCourse> getRegisteredShortCourse(Participant participant);

    boolean save(Participant participant, String paymentId);
    
    boolean save(Participant participant, Payment payment);
    
    boolean existsEmail(String email);
    
    boolean existsCpf(String cpf);

}
