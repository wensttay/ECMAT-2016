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

    boolean saveShortCourse(ShortCourse shortCourse);

    boolean updateShortCourse(ShortCourse shortCourse);

    boolean deleteShortCourse(ShortCourse shortCourse);

    List<ShortCourse> listAllShortCourse();

    ShortCourse searchShortCourseById(Integer id);

    boolean addParticipantInShortCourse(ShortCourse shortCourse, Participant participant);

    int getShortCourseCurrentEnrollment(ShortCourse shortCourse);

    List<Participant> getShortCourseParticipants(ShortCourse shortCourse);

    boolean removeParticipantFromShortCourse(ShortCourse shortCourse, Participant participant);

}
