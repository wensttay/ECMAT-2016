package io.github.herocode.ecmat.enums;

import java.time.LocalDateTime;

/**
 *
 * @version 3.1
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 08/01/2017 - 12:01:31
 */
public enum ShortCourseWorkShift {
    MORNING("Manhã", 12),
    AFTERNOON("Tarde", 15),
    NIGHT("Noite", 24);

    private String shift;
    private int finalTime;

    private ShortCourseWorkShift(String shift, int startHour) {
        this.shift = shift;
        this.finalTime = startHour;
    }

    public String getShift() {
        return shift;
    }

    public int getFinalTime() {
        return finalTime;
    }

    public static ShortCourseWorkShift getShift(LocalDateTime startTime) {

        ShortCourseWorkShift[] workShifts = ShortCourseWorkShift.values();

        for (int i = 0; i < workShifts.length; i++) {
            if (workShifts[i].getFinalTime() > startTime.getHour()) {
                return workShifts[i];
            }
        }

        return workShifts[workShifts.length - 1];
    }

}
