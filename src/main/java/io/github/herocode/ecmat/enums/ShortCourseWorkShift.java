/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.herocode.ecmat.enums;

import java.time.LocalDateTime;

/**
 *
 * @author wensttay
 */
public enum ShortCourseWorkShift{
    MORNING("Manhã", 12),
    AFTERNOON("Tarde", 15),
    NIGHT("Noite", 24);

    private String shift;
    private int finalTime;

    private ShortCourseWorkShift(String shift, int startHour){
        this.shift = shift;
        this.finalTime = startHour;
    }

    public String getShift(){
        return shift;
    }

    public int getFinalTime(){
        return finalTime;
    }
    
    public static ShortCourseWorkShift getShift(LocalDateTime startTime){
        
        ShortCourseWorkShift[] workShifts = ShortCourseWorkShift.values();
        
        for ( int i = 0; i < workShifts.length; i++ ){
            if ( workShifts[i].getFinalTime() > startTime.getHour() ){
                return workShifts[i];
            }
        }

        return workShifts[workShifts.length - 1];
    }

}
