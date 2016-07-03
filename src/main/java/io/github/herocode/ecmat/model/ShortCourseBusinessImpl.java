/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.model;

import io.github.herocode.ecmat.interfaces.ShortCourseBusiness;
import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import java.util.List;
import io.github.herocode.ecmat.interfaces.ShortCourseDao;
import java.util.Collections;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ShortCourseBusinessImpl implements ShortCourseBusiness {

    private ShortCourseDao shortCourseDao;

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
    public synchronized boolean addParticipantInShortCourse(ShortCourse shortCourse, Participant participant) {

        if (getShortCourseCurrentEnrollment(shortCourse) < shortCourse.getMaxEnrollment()) {
            return shortCourseDao.addParticipant(shortCourse, participant);
        }

        return false;
    }

    @Override
    public boolean saveShortCourse(ShortCourse object) {

        return shortCourseDao.save(object);
    }

    @Override
    public boolean deleteShortCourse(ShortCourse object) {

        return shortCourseDao.delete(object);
    }

    @Override
    public boolean updateShortCourse(ShortCourse object) {

        return shortCourseDao.update(object);
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
