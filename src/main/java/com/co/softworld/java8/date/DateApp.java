package com.co.softworld.java8.date;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DateApp {

    public void verifyDate() {
        log.info("verifyDate...");
        LocalDate date1 = LocalDate.of(2022, 2, 16);
        LocalDate date2 = LocalDate.now();

        LocalTime time1 = LocalTime.of(21, 32);
        LocalTime time2 = LocalTime.now();
        
        log.info("date1 " + date1 + " is before date2 " + date2 + " " + date1.isBefore(date2));
        log.info("date1 " + date1 + " is after date2 " + date2 + " " + date1.isAfter(date2));
        log.info("date1 " + date1 + " is equals date2 " + date2 + " " + date1.isEqual(date2));

        log.info("time1 " + time1 + " is before time2 " + time2 + " " + time1.isBefore(time2));
        log.info("time1 " + time1 + " is after time2 " + time2 + " " + time1.isAfter(time2));
    }

    public void calculateTime() throws InterruptedException {
        log.info("calculateTime...");
        Instant init =   Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        log.info(String.valueOf(Duration.between(init, end)));
    }

    public void calculatePeriod() {
        log.info("calculatePeriod...");
        LocalDate dateInit = LocalDate.of(1990, 4, 26);
        LocalDate dateEnd = LocalDate.now();
        log.info(String.valueOf(Period.between(dateInit, dateEnd)));
    }

    public void convertStringToLocalDate() {
        log.info("convertStringToLocalDate...");
        String dateString = "26/04/1990";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        log.info(String.valueOf(localDate));
    }

    public void convertLocalDateToString() {
        log.info("convertLocalDateToString...");
        LocalDate date = LocalDate.of(2022, 2, 16);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateString = date.format(formatter);
        log.info(dateString);
    }

    public void convertStringToLocalDateWithoutFormatter() {
        log.info("convertStringToLocalDateWithoutFormatter...");
        String dateString = "1990-04-26";
        LocalDate localDate = LocalDate.parse(dateString);
        log.info(String.valueOf(localDate));
    }

    public static void main(String[] args) throws InterruptedException {
        DateApp dateApp = new DateApp();
        dateApp.verifyDate();
        dateApp.calculateTime();
        dateApp.calculatePeriod();
        dateApp.convertStringToLocalDate();
        dateApp.convertLocalDateToString();
        dateApp.convertStringToLocalDateWithoutFormatter();
    }
}
