/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.interfaces.ParticipantBusiness;
import io.github.herocode.ecmat.interfaces.ParticipantDao;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ParticipantBusinessImpl implements ParticipantBusiness{

    private ParticipantDao participantDao;
    
    @Override
    public boolean saveParticipant(Participant participant) {
        
        return participantDao.save(participant);
    }

    @Override
    public boolean updateParticipant(Participant participant) {
        
        return participantDao.update(participant);
    }

    @Override
    public boolean deleteParticipant(Participant participant) {
        
        return participantDao.delete(participant);
    }

    @Override
    public Participant searchParticipantById(Integer id) {
        
        return participantDao.searchById(id);
    }

    @Override
    public List<ShortCourse> getRegisteredShortCourse(Participant participant) {
        
        return participantDao.getRegisteredShortCourse(participant);
    }

    @Override
    public List<Participant> listAllParticipants() {
        
        return participantDao.listAll();
    }
    
}
