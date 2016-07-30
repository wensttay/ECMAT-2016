/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.entity;

import io.github.herocode.ecmat.enums.ShortCourseType;
import io.github.herocode.ecmat.enums.ShortCourseWorkShift;
import java.time.LocalDateTime;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class ShortCourse{

    private int                     id;
    private int                     maxEnrollment;
    private LocalDateTime           startDate;
    private LocalDateTime           endDate;
    private String                  title;
    private String                  description;
    private String                  professor;
    private String                  place;
    private String                  equipmentNeeded;
    private ShortCourseType         shortCourseType;
    private ShortCourseWorkShift    shortCourseWorkShift;
    

    public ShortCourse(){
    }

    public ShortCourse(int id, int maxEnrollment, LocalDateTime startDate, LocalDateTime endDate, String title, String description, String professor, String place, String equipmentNeeded, ShortCourseType shortCourseType){
        this.id                     = id;
        this.maxEnrollment          = maxEnrollment;
        this.startDate              = startDate;
        this.endDate                = endDate;
        this.title                  = title;
        this.description            = description;
        this.professor              = professor;
        this.place                  = place;
        this.equipmentNeeded        = equipmentNeeded;
        this.shortCourseType        = shortCourseType;
        this.shortCourseWorkShift   = ShortCourseWorkShift.getShift(startDate);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getMaxEnrollment(){
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment){
        this.maxEnrollment = maxEnrollment;
    }

    public LocalDateTime getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate){
        this.startDate              = startDate;
        this.shortCourseWorkShift   = ShortCourseWorkShift.getShift(startDate);
    }

    public LocalDateTime getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate){
        this.endDate = endDate;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getProfessor(){
        return professor;
    }

    public void setProfessor(String professor){
        this.professor = professor;
    }

    public String getPlace(){
        return place;
    }

    public void setPlace(String place){
        this.place = place;
    }

    public String getEquipmentNeeded(){
        return equipmentNeeded;
    }

    public void setEquipmentNeeded(String equipmentNeeded){
        this.equipmentNeeded = equipmentNeeded;
    }

    public ShortCourseType getShortCourseType(){
        return shortCourseType;
    }

    public void setShortCourseType(ShortCourseType shortCourseType){
        this.shortCourseType = shortCourseType;
    }

    public ShortCourseWorkShift getShortCourseWorkShift(){
        return shortCourseWorkShift;
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Short Course: ").
                append(title).
                append(" Type: ").
                append(shortCourseType.getTypeName()).
                append(" Description: ").
                append(description).
                append(" Place: ").
                append(place).
                append(" Work Shift: ").
                append(shortCourseWorkShift.getShift()).
                append(" Start Date: ").
                append(startDate).
                append(" End Date: ").
                append(endDate).
                append(" Professor: ").
                append(professor).
                append(" Max Enrollment: ").
                append(maxEnrollment).
                append(" Equipament Needed: ").
                append(equipmentNeeded);
        
        return sb.toString();
    }

}
