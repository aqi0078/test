package com.zdz.test.test.tmp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-10-11
 */
public class H {
    public static ThreadLocal<String> tl=new ThreadLocal<>();
    public static String main1() {
        String a="";
        try{

            a="123";
            return a;
        }finally {
            a="456";
            System.out.println("==");
        }
//        return "null";
//        int i=0;
//        try {
//            return i++;
//        }finally {
//            i++;
////            return i;
//        }
    }
    public static void main(String[] args) {

        System.out.println(new Timestamp(System.currentTimeMillis()));
        String abc="";
        abc.concat(",");
        Map<String,String> map=new HashMap<>();
        map.put("10","10");
        map.put("20","20");
        String ss=map.remove("10");//删数据，并且返回删的那个key的值
        map.get("20");//获取数据
        map.keySet();
        for (String str:map.keySet()) { 
            if (str.compareTo("值")==0){
                System.out.println("你要的key");
            }
        }
        for (String str:map.keySet()) {
            System.out.println(str+"=str是key ="+map.get(str));
        }
        System.out.println(ss+"=="+map.size());
        System.out.println(main1());
        String str="111/2";
        System.out.println(str.split("\\/")[1]);
//
//        Long overdueDay=0L;
//        Date stringToDate = null;
//        try {
//            stringToDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-17 15:00:00");
//            overdueDay=(System.currentTimeMillis()-stringToDate.getTime())/(1000*60*60*24);
//        } catch (ParseException e) {
//        }
//        System.out.println("====="+overdueDay);
//        System.out.println(main1());

        String str11=new SimpleDateFormat("yyyyMMdd").format(new Date());
        System.out.println("========new Date().getTime()========"+str11);

        try {
            new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-10 15:30:11");
            System.out.println("========new D========"+new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-10 15:30:11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BigDecimal totalLoanAmount=BigDecimal.ZERO;
        BigDecimal totalLoanAmount1=BigDecimal.TEN;
        totalLoanAmount=totalLoanAmount.add(totalLoanAmount1);
        System.out.println("================"+totalLoanAmount);
        String st="2019-10-16";
        String st1="2019-10-14";
        Long overdueDay=0L;
        String[] da=null;
        if (st==null){
            overdueDay=LocalDate.now().toEpochDay();
        }else{
            da=String.valueOf(st).substring(0,10).split("-");
            overdueDay=LocalDate.of(Integer.valueOf(da[0]),Integer.valueOf(da[1]),Integer.valueOf(da[2])).toEpochDay();
        }
        String[] deadline=st1.split("-");
        overdueDay=overdueDay-LocalDate.of(Integer.valueOf(deadline[0]),Integer.valueOf(deadline[1]),Integer.valueOf(deadline[2])).toEpochDay();

        System.out.println("两个时间之间的天数是：" + overdueDay + " 天。");
//        System.out.println("两个时间之间的天数是：" + (now.toEpochDay() - start.toEpochDay()) + " 天。");
        ThreadLocalRandom.current().nextInt(5);
//        ThreadLocalRandom tlr=new ThreadLocalRandom();

//        String str="2019-10-10";
//        Timestamp ts = Timestamp.valueOf(str.concat(" 24:00:00"));
//        System.out.println(ts);
//        tl.set("main");
//
//        Thread t=new Thread(){
//            @Override
//            public void run() {
//
//                System.out.println(tl.get());
//            }
//        };
//        t.start();
//
//        System.out.println("---"+tl.get());
//        try {
//            Date stringToDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-10 15:30:11");
//            long ll=(System.currentTimeMillis()-stringToDate.getTime())/(1000*60*60*24);
//
//            System.out.println(ll);
//            System.out.println(System.currentTimeMillis());
//            System.out.println(stringToDate.getTime());
//            System.out.println(System.currentTimeMillis()-stringToDate.getTime());
//            System.out.println(1000*60*60*24);
//
//            System.out.println(stringToDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}
