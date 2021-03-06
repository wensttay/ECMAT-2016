package io.github.herocode.ecmat.interfaces;

import io.github.herocode.ecmat.entity.Participant;
import io.github.herocode.ecmat.entity.ShortCourse;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface ShortCourseDao extends Dao<ShortCourse, Integer> {

    List<Participant> getShortCourseParticipants(ShortCourse shortCourse);

    List<ShortCourse> getParticipantShortCourses(Participant participant);

    int getCurrentEnrollment(ShortCourse shortCourse);

    boolean removeParticipant(ShortCourse shortCourse, Participant participant);

    boolean addParticipant(ShortCourse shortCourse, Participant participant);

    public String getRelationWithParticipantTableName();

    public Participant fillParticipantObejct(ResultSet rs);

    Map<Integer, Integer> getShortcoursersCurrentEnrollments();

}
