package com.zdz.test.test.testThread;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;

/**
 * @Description:
 * @Date: 2021/8/27
 */
@Data
@RequiredArgsConstructor
public class A {
    private final Integer num;

    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter
            .ofPattern("yyyyMMddHH");
    public static String getLocalDateTimeString() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    public static String getLocalDateString(int n) {
        return LocalDate.now().plusDays((long) n).format(DATETIME_FORMATTER);
    }

    public static Long getLocalPrevHourDateInt() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Calendar cal = Calendar.getInstance();
        String start_update = format.format(cal.getTime());
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)-2);
        String end_update = format.format(cal.getTime());
        return Long.valueOf(end_update);
    }
    public static Long getLocalDateHourTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(System.currentTimeMillis()));
        String end_update = format.format(cal.getTime());
        return Long.valueOf(end_update);
    }
    public static Long getLocalHourDateInt(int n) {
        return Long.parseLong(LocalDate.now().plus(n, ChronoUnit.HOURS).format(DATETIME_FORMATTER));
    }

    public static Long getLocalPrevHourDateInt(int n) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Calendar cal = Calendar.getInstance();
        String start_update = format.format(cal.getTime());
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - n);
        String end_update = format.format(cal.getTime());
        return Long.valueOf(end_update);
    }
    public static Long getLocalPrevHourDateInt1(int n) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Calendar cal = Calendar.getInstance();
        String start_update = format.format(new Date(System.currentTimeMillis()));
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - n);
        String end_update = format.format(cal.getTime());
        return Long.valueOf(end_update);
    }

    public static Long getLocalDateHourTime1() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(1637284052L));
        String end_update = format.format(cal.getTime());
        return Long.valueOf(end_update);
    }
    public static void main(String[] args) {

        HashSet set = new HashSet();
        Long l1 = 1L;
        set.add(l1);
        boolean b = set.contains(1L);
        System.out.println(getLocalDateHourTime1());
        BigDecimal b1 =new BigDecimal("0.00001");
        BigDecimal b2 =new BigDecimal("0.55");

        System.out.println(b1.multiply(b2).setScale(6, BigDecimal.ROUND_DOWN));


//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        System.out.println(list.subList(3,list.size()));
//
//
//        System.out.println(getLocalDateTimeString());
//        System.out.println(getLocalDateInt());
    }
}
