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
import io.github.herocode.ecmat.persistence.ParticipantDaoImpl;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ParticipantBusinessImpl implements ParticipantBusiness{

    private ParticipantDao participantDao;

    public ParticipantBusinessImpl() {
        this.participantDao = new ParticipantDaoImpl();
    }
    
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
    public Participant searchParticipantById(int id) {
        
        return participantDao.searchById(id);
    }

    @Override
    public List<ShortCourse> getRegisteredShortCourse(Participant participant) {
        
        return Collections.unmodifiableList(participantDao.getRegisteredShortCourse(participant));
    }

    @Override
    public List<Participant> listAllParticipants() {
        
        return Collections.unmodifiableList(participantDao.listAll());
    }

    @Override
    public List<Participant> searchParticipantByAttribute(String key, String value) {
        
        return Collections.unmodifiableList(participantDao.searchByAttribute(key, value));
    }

    @Override
    public List<Participant> searchParticipantByAttributes(Map<String, String> map) {
        
        return Collections.unmodifiableList(participantDao.searchByAttributes(map));
    }

}
