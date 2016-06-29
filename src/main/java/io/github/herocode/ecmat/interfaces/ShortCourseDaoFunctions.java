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
public interface ShortCourseDaoFunctions {
    
    List<Participant> getShortCourseParticipants(ShortCourse shortCourse);
    
    int getCurrentEnrollment(ShortCourse shortCourse);
    
    boolean removeParticipant(ShortCourse shortCourse, Participant participant);
    
    boolean addParticipant(ShortCourse shortCourse, Participant participant);
    
}
