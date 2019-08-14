package com.zdz.test.test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangdezhi
 */
public class TestMain {


    public static void main(String[] args) {
        Object obj=null;
        System.out.println(Long.valueOf(String.valueOf(obj)));


    }
    public static void main1q1(){


//        List<String> list=new ArrayList<>();
//        list.add("11");
//
//        List<String> list1=new ArrayList<>();
//        list1.add("11");
//        list.removeAll(list1);
//        list1.addAll(list);
//        System.out.println(list);
//        System.out.println(list1);

//        String str=LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmm"));
//
//        LocalDateTime localDateTime=LocalDateTime.parse("0000", DateTimeFormatter.ofPattern("HHmm"));
//
//
//        ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
//

//
//
//        System.out.println(Date.from(zonedDateTime.toInstant()));
//        System.out.println(date);
//        System.out.println(str);

//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime time = LocalDateTime.now();
//        String localTime = df.format(time);
//        LocalDateTime ldt = LocalDateTime.parse("2018-06-01 00:00:00",df);
//        System.out.println("LocalDateTime转成String类型的时间："+localTime);
//        System.out.println("String类型的时间转成LocalDateTime："+ldt);
//        Integer now=Integer.valueOf(ldt.format(DateTimeFormatter.ofPattern("HHmm")));
//        System.out.println(now);
//        BigDecimal behalfSumAmount=BigDecimal.ZERO;
//        System.out.println(behalfSumAmount.compareTo(BigDecimal.ZERO));
//        behalfSumAmount=behalfSumAmount.add(new BigDecimal("111"));
//        behalfSumAmount=getData(behalfSumAmount);
//        System.out.println(behalfSumAmount);

        Integer now=Integer.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmm")));

        System.out.println(now);

//获取时间实例
        Instant instant = new Date().toInstant();
//获取时间地区ID
        ZoneId zoneId = ZoneId.systemDefault();
//转换为LocalDate
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();

//获得LocalDateTime时间戳(东八区)
       // localDate .toEpochSecond(ZoneOffset.of("+8"));

        System.out.println(localDate.toString());

        String[] behalfAt=localDate.toString().split("-");

        System.out.println(behalfAt[0]+behalfAt[1]+behalfAt[2]);
//        String[] tmp=time.split(":");
//        if (tmp.length==2){
//            lastTime=Integer.valueOf(tmp[0])*100+Integer.valueOf(tmp[1]);
//        }else{
//            lastTime=Integer.valueOf(time);
//        }

    }

    private static BigDecimal getData(BigDecimal behalfSumAmount){
        behalfSumAmount=behalfSumAmount.add(new BigDecimal("111"));
        System.out.println(behalfSumAmount);
        return behalfSumAmount;
    }


}
