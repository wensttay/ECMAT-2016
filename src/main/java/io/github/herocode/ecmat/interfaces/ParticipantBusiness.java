/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface ParticipantBusiness {

    boolean saveParticipant(Participant participant);

    boolean updateParticipant(Participant participant);

    boolean deleteParticipant(Participant participant);

    List<ShortCourse> listAllParticipants();

    Participant searchParticipantById(Integer id);

}
