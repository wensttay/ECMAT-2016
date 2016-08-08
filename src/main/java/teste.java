
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.apache.commons.codec.digest.DigestUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class teste {

    public static void main(String[] args) {

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
//        String d1 = "21061994";
//
//        LocalDate d = LocalDate.parse(d1, dtf);
//        System.out.println(d);

//        LocalDateTime dateTime = LocalDateTime.of(2016, Month.AUGUST, 25, 15, 45);
//        Timestamp valueOf = java.sql.Timestamp.valueOf(dateTime);
//        System.out.println(valueOf.toString());
System.out.println(String.valueOf("991.953.013-13".hashCode()));
    }

}
