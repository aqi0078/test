package com.zdz.test.test.tmp;

import com.alibaba.excel.util.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangdezhi
 * @date 2020-03-17
 */
public class Test20200317 {
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }
    public static void main(String[] args) {
        System.out.println(44559518/1000/60/60);
        System.out.println(getEndTime().getTime()-System.currentTimeMillis());
        System.out.println(addDay(new Date(),-5));
        System.out.println("60&时起".replaceAll("&时起",""));
        System.out.println("60&时起".split("&时起")[0]);
        System.out.println(new Date());
        System.out.println(new Date(System.currentTimeMillis()+10*60*1000));
        System.out.println(System.currentTimeMillis()-new Date(System.currentTimeMillis()+10*60*1000).getTime()>1000);
        encodePassword("123测试abcDEF=+*&");
        System.out.println(encodePassword("123测试abcDEF=+*&"));
    }
        /**
     * @Comment SHA1加密密码
         *
     * @return
     */
    public static String encodePassword(String psw) {
        if(StringUtils.isEmpty(psw)){
            return null;
        }else{
            return DigestUtils.sha1Hex(psw);
        }
    }
//    public static String encodePassword1(String psw) {
//        if(StringUtils.isEmpty(psw)){
//            return null;
//        }else{
//            return DigestUtils.;
//        }
//    }
}
