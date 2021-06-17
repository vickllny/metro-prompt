package com.vickllny.metro.prompt.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String dateHash(){
        final LocalDate now = LocalDate.now();
        final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd");
        return dateHash(now, pattern);
    }

    public static String dateHash(LocalDate date, DateTimeFormatter formatter){
        return formatter.format(date);
    }
}
