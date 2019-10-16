package com.zdz.test.test.tmp;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-10-11
 */
public class H {
    public static ThreadLocal<String> tl=new ThreadLocal<>();
    public static int main1() {
        int i=0;
        try {
            return i++;
        }finally {
            i++;
//            return i;
        }
    }
    public static void main(String[] args) {
        String str="111/2";
        System.out.println(str.split("\\/")[1]);
        ;
        System.out.println(main1());
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
