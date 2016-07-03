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

    boolean addParticipantInShortCourse(ShortCourse shortCourse, Participant participant);

    boolean deleteShortCourse(ShortCourse object);

    int getShortCourseCurrentEnrollment(ShortCourse shortCourse);

    List<Participant> getShortCourseParticipants(ShortCourse shortCourse);

    List<ShortCourse> listAllShortCourse();

    boolean removeParticipantFromShortCourse(ShortCourse shortCourse, Participant participant);

    boolean saveShortCourse(ShortCourse object);

    ShortCourse searchShortCourseById(Integer id);

    boolean updateShortCourse(ShortCourse object);
    
}
