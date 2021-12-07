package com.zdz.test.test.tmp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

/**
 * @Description:
 * @Date: 2020/12/31
 */
public class Test1231 {

//    public static String getDayofMonth(){
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        Calendar calendar = Calendar.getInstance();
//        Calendar c = Calendar.getInstance();
//        int day = c.get(Calendar.DAY_OF_MONTH);
//        if (day == 1){
//            calendar.add(Calendar.MONTH, -1);
//        }else{
//            calendar.add(Calendar.MONTH, -2);
//        }
//        calendar.add(Calendar.DATE,1);
//        return format.format(calendar.getTime());
//    }
public static String getDayofMonth1(){
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    if (day == 1){
        calendar.add(Calendar.MONTH,-1);
    }else{
        calendar.add(Calendar.MONTH,0);
    }
    calendar.setTime(new Date());
    calendar.set(Calendar.DAY_OF_MONTH,1);
    return format.format(calendar.getTime());
}


    public static String getDayofMonth(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.setTime(new Date());
        if (day == 1){
            calendar.add(Calendar.MONTH,-1);
        }else{
            calendar.add(Calendar.MONTH,0);
        }
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return format.format(calendar.getTime());
    }

    public static Long getDate(Date date){
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyyMMddHH");
        return Long.valueOf(formatter.format(new Date()));
    }

    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        Long a=100L;
        System.out.println(a.equals(100L));



        String str ="abc.bcd";

        String str1 =str.replace(".","");
        System.out.println(str1);
        System.out.println("dfdgh".replace(".",""));


        System.out.println(addDay(new Date(),-1));
        System.out.println(getDate(addDay(new Date(),-1)));
//        BigDecimal b = BigDecimal.ZERO;
//        b = b.add(BigDecimal.ONE);
        System.out.println(getDate(new Date()));
//        HashSet<Integer> set=new HashSet<Integer>();
//        System.out.println(set.add(1));
//        System.out.println(set.add(1));
//
//        HashSet<Integer> set1=new HashSet<Integer>();
//        set1.add(1);
//
//
//        System.out.println(set.addAll(set1));
//        Boolean istrye =false;
//        if(null == istrye){
//            System.out.println("====11====");
//        }
//        System.out.println("====22====");
//        try {
//            int i=1/0;
//        }catch (Exception e){
//            System.out.println("========");
//            int i=1/0;
//        }
//        System.out.println("-----1------firstDay:"+getDayofMonth());
    }
}
