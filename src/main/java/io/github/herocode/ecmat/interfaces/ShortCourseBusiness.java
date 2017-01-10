package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import io.github.herocode.ecmat.exceptions.EnrollingShortCourseException;
import java.util.List;
import java.util.Map;

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

    boolean addParticipantInShortCourse(ShortCourse shortCourse, Participant participant) throws EnrollingShortCourseException;

    int getShortCourseCurrentEnrollment(ShortCourse shortCourse);

    List<Participant> getShortCourseParticipants(ShortCourse shortCourse);

    boolean removeParticipantFromShortCourse(ShortCourse shortCourse, Participant participant);

    Map<Integer, Integer> getShortcoursersCurrentEnrollments();

}
