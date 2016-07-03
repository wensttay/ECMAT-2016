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
public interface ShortCourseBusiness {

    boolean addParticipant(ShortCourse shortCourse, Participant participant);

    boolean delete(ShortCourse object);

    int getCurrentEnrollment(ShortCourse shortCourse);

    List<Participant> getShortCourseParticipants(ShortCourse shortCourse);

    List<ShortCourse> listAll();

    boolean removeParticipant(ShortCourse shortCourse, Participant participant);

    boolean save(ShortCourse object);

    ShortCourse searchById(Integer id);

    boolean update(ShortCourse object);
    
}
