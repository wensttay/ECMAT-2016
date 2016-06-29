/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.entity;

import io.github.herocode.ecmat.interfaces.ShortCourseDaoFunctions;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ShortCourse {
    
    private int                     id;
    private int                     maxEnrollment;
    private LocalDate               date;
    private String                  title;
    private String                  professor;
    private ShortCourseDaoFunctions daoFunctions;

    public ShortCourse() { }

    public ShortCourse(int id, LocalDate date, String title, String professor, int maxEnrollment) {
        this.date           = date;
        this.title          = title;
        this.professor      = professor;
        this.maxEnrollment  = maxEnrollment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getCurrentEnrollment() {
        
        return daoFunctions.getCurrentEnrollment(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Participant> getParticipants() {
        
        List<Participant> participants = daoFunctions.getShortCourseParticipants(this);
        
        return Collections.unmodifiableList(participants);
    }
    
    public void removeParticipant(Participant participant){
        
        daoFunctions.removeParticipant(this, participant);
    }
    
    public void addParticipant(Participant participant){
        
        daoFunctions.addParticipant(this, participant);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Short Course: ").
                append(title).
                append(" Date: ").
                append(date).
                append(" Professor: ").
                append(professor).
                append(" Current Enrollment: ").
                append(getCurrentEnrollment());

        return sb.toString();
    }
    
}
