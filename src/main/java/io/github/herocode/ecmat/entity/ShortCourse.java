/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.entity;

import java.time.LocalDateTime;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ShortCourse {
    
    private int             id;
    private int             maxEnrollment;
    private LocalDateTime   date;
    private String          title;
    private String          professor;

    public ShortCourse() { }

    public ShortCourse(int id, LocalDateTime date, String title, String professor, int maxEnrollment) {
        this.date           = date;
        this.title          = title;
        this.professor      = professor;
        this.maxEnrollment  = maxEnrollment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                append(" Max Enrollment: ").
                append(maxEnrollment);

        return sb.toString();
    }
    
}
