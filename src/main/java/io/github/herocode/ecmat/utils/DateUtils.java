/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.herocode.ecmat.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class DateUtils {

    public static LocalDate getLocalDateFromString(String sDate) {

        DateTimeFormatter dateTimeFormatter;
        LocalDate lDate = null;

        try {

            dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            lDate = LocalDate.parse(sDate, dateTimeFormatter);
        } catch (Exception ex1) {

            try {

                dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                lDate = LocalDate.parse(sDate, dateTimeFormatter);
            } catch (Exception ex2) {

                try {

                    dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    lDate = LocalDate.parse(sDate, dateTimeFormatter);
                } catch (Exception ex3) {

                    try {

                        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        lDate = LocalDate.parse(sDate, dateTimeFormatter);
                    } catch (Exception ex) {
                    }
                }
            }
        }

        return lDate;
    }

}
