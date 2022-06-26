package com.example.springdatadb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
    LocalDate localdate1 = LocalDate.of(2011,1,10);
    LocalDate localdate2 = LocalDate.of(2012,10,11);
    int day1 = localdate1.getDayOfMonth();
    int day2 = localdate2.getDayOfMonth();
    LocalDate localDate = localdate1.withDayOfYear(300);
    LocalDate localDate3 = localDate.plusMonths(1);
//        System.out.println(localDate.getDayOfMonth()+ " "+localDate.getMonth() + " " + localDate.getDayOfYear());
//        System.out.println(localDate3.getDayOfMonth()+ " "+localDate3.getMonth() + " " + localDate3.getDayOfYear());
//        System.out.println(localdate2.getDayOfYear());
//        System.out.println(day1>day2);
//        System.out.println(localdate1.isBefore(localdate2));
        Date date1 = new Date(2011,1,10);
        Date date2 = new Date(2012,10,11);
//        System.out.println(date1.getMonth()>date2.getMonth());
        LocalTime localTime1 = LocalTime.of(12,12,12);
        LocalTime localTime2 = LocalTime.of(13,13,13);
//        System.out.println(localTime1.getHour()>localTime2.getHour());

//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.parse("июня 5, 2018 12:10:56", formatter1);
//        System.out.println(localDateTime);
//
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
//        LocalDate localDate5 = LocalDate.now();
//        System.out.println(formatter1.format(localDate5));
    }

}
