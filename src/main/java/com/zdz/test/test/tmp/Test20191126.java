package com.zdz.test.test.tmp;

import org.apache.poi.ss.usermodel.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangdezhi
 * @date 2019-11-26
 */
public class Test20191126 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(0%100000);
        System.out.println(100005%100000);
        String str=String.format("%06d", 66666);
        System.out.println(str);
        try {
            ma();
        } catch (Exception e) {
            System.out.println("=======44444444444======");
            e.printStackTrace();
        }
    }
    public static void ma()  {
        try {
            int i=1/0;
        } catch (Exception e) {
            System.out.println("=============");
            e.printStackTrace();
        }finally {
            System.out.println("=-----------");
        }
    }
}
