/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import io.github.herocode.ecmat.interfaces.ShortCourseBusiness;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.enums.ErrorMessages;
import io.github.herocode.ecmat.enums.PaymentStatus;
import io.github.herocode.ecmat.exceptions.EnrollingParticipantException;
import java.util.List;
import io.github.herocode.ecmat.interfaces.ShortCourseDao;
import io.github.herocode.ecmat.persistence.ShortCourseDaoImpl;
import java.util.Collections;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ShortCourseBusinessImpl implements ShortCourseBusiness {

    private static ShortCourseBusinessImpl shortCourseBusinessImpl;

    private ShortCourseDao shortCourseDao;

    private ShortCourseBusinessImpl() {
        
        shortCourseDao = new ShortCourseDaoImpl();
    }
    
    public ShortCourseBusinessImpl getInstance(){
        
        if(shortCourseBusinessImpl == null){
            
            shortCourseBusinessImpl = new ShortCourseBusinessImpl();
        }
        
        return shortCourseBusinessImpl;
    }

    @Override
    public List<Participant> getShortCourseParticipants(ShortCourse shortCourse) {

        List<Participant> shortCourseParticipants = shortCourseDao.getShortCourseParticipants(shortCourse);

        return Collections.unmodifiableList(shortCourseParticipants);

    }

    @Override
    public int getShortCourseCurrentEnrollment(ShortCourse shortCourse) {

        return shortCourseDao.getCurrentEnrollment(shortCourse);
    }

    @Override
    public boolean removeParticipantFromShortCourse(ShortCourse shortCourse, Participant participant) {

        return shortCourseDao.removeParticipant(shortCourse, participant);
    }

    @Override
    public synchronized boolean addParticipantInShortCourse(ShortCourse shortCourse, Participant participant) throws EnrollingParticipantException {
        
        //falta

        return false;
    }

    @Override
    public boolean saveShortCourse(ShortCourse shortCourse) {

        return shortCourseDao.save(shortCourse);
    }

    @Override
    public boolean deleteShortCourse(ShortCourse shortCourse) {

        return shortCourseDao.delete(shortCourse);
    }

    @Override
    public boolean updateShortCourse(ShortCourse shortCourse) {

        return shortCourseDao.update(shortCourse);
    }

    @Override
    public ShortCourse searchShortCourseById(Integer id) {

        return shortCourseDao.searchById(id);
    }

    @Override
    public List<ShortCourse> listAllShortCourse() {

        List<ShortCourse> allShortCourse = shortCourseDao.listAll();

        return Collections.unmodifiableList(allShortCourse);
    }

}
