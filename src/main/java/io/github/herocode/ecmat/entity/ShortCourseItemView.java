/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.herocode.ecmat.entity;

import io.github.herocode.ecmat.enums.ShortCourseType;
import io.github.herocode.ecmat.enums.ShortCourseWorkShift;
import java.io.Serializable;

/**
 *
 * @author wensttay
 */
public class ShortCourseItemView implements Comparable<ShortCourseItemView>, Serializable{

    private int                     id;
    private int                     maxEnrollment;
    private String                  duration;
    private String                  title;
    private String                  url;
    private ShortCourseType         shortCourseType;
    private ShortCourseWorkShift    shortCourseWorkShift;
    private boolean                 userIsRegistred;

    public ShortCourseItemView(){
    }

    public ShortCourseItemView(int id, int maxEnrollment, String duration, String title, String url, ShortCourseType shortCourseType, ShortCourseWorkShift shortCourseWorkShift, boolean userIsRegistred){
        this.id                     = id;
        this.maxEnrollment          = maxEnrollment;
        this.duration               = duration;
        this.title                  = title;
        this.url                    = url;
        this.shortCourseType        = shortCourseType;
        this.shortCourseWorkShift   = shortCourseWorkShift;
        this.userIsRegistred        = userIsRegistred;
    }

    public ShortCourseItemView(ShortCourse course, boolean userIsRegistred){
        this.id                     = course.getId();
        this.maxEnrollment          = course.getMaxEnrollment();
        this.duration               = course.getDuration();
        this.title                  = course.getTitle();
        this.url                    = course.getUrl();
        this.shortCourseType        = course.getShortCourseType();
        this.shortCourseWorkShift   = course.getShortCourseWorkShift();
        this.userIsRegistred        = userIsRegistred;
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

    public String getDuration(){
        return duration;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
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

    public void setShortCourseWorkShift(ShortCourseWorkShift shortCourseWorkShift){
        this.shortCourseWorkShift = shortCourseWorkShift;
    }

    public boolean isUserIsRegistred(){
        return userIsRegistred;
    }

    public void setUserIsRegistred(boolean userIsRegistred){
        this.userIsRegistred = userIsRegistred;
    }

    @Override
    public int compareTo(ShortCourseItemView o){

        if ( this.userIsRegistred ){
            return -1;
        }
        if ( o.isUserIsRegistred() ){
            return 1;
        }
        
        return this.getTitle().compareTo(o.getTitle());
    }

}
