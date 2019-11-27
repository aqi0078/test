package com.zdz.test.test.tmp;

//import org.apache.commons.lang3.time.DateUtils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangdezhi
 * @date 2019-11-21
 */
public class test20191121 {
    public static String dateFromString(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return date != null ? simpleDateFormat.format(date) : null;
    }
    public static void main(String[] args) {
        Object ll=-1;
        Integer tmp= (Integer) ll;
        System.out.println(tmp);
        Map<String,Object>map=new HashMap<>();
        map.put("1","签到");
        HashMap<String,Object> m= (HashMap<String, Object>) JSON.parseObject(JSON.toJSONString(map),Map.class);
//        List<HashMap> rule= JSON.parseArray(JSON.toJSONString(map),HashMap.class);
        System.out.println(m.get("1"));
        DateUtils.truncate(DateUtils.addDays(new Date(), -1), 5);
        String str=dateFromString(DateUtils.truncate(DateUtils.addDays(new Date(), -1), 5),"yyyy-MM-dd");
        System.out.println(str);

//        AA a=new AA();
//
//        a.setA(1);
//        a.add(2);
//
//        System.out.println(a.getA());
//        System.out.println(a.getB());
//        int i=DateTime.now().dayOfYear().get();
//        System.out.println(i);
//        char[] data=new char[365];
//        for (int i = 10; i < data.length; i++) {
//            System.out.println((long)data[i]);
//        }
//
//        System.out.println("--"+(long)data[364]);
//        System.out.println("-1-"+data[364]);
//        data[364]=(char)((long)data[364]+1);
//        System.out.println("=="+(long)data[364]);
//        System.out.println("=1="+data[364]);
//        for (int i = 10; i < data.length; i++) {
//            data[i]= (char) (i);
//        }
//        String str=new String(data);
//
//        System.out.println(str);
//        System.out.println(str.length());
//        long su=13;
//        char[] chars=str.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if ((long)chars[i]!=0){
//                if(su-(long)chars[i]>0){
//                    su=su-(long)chars[i];
//                    chars[i]=(char)0;
//                }else if(su-(long)chars[i]<0){
//                    chars[i]=(char)((long)chars[i]-su);
//                    break;
//                }else{
//                    chars[i]=(char)0;
//                    break;
//                }
//            }
//        }
//
//        System.out.println("=================================");
//        String data1=new String(chars);
//        System.out.println(data1);
//        System.out.println(data1.length());
//
//        System.out.println(str.equals(data1));
//        System.out.println((int)str.charAt(11));
//        System.out.println((int)data1.charAt(11));
//        for (int i = 0; i < chars.length; i++) {
//            System.out.println(chars[i]+"=="+(long)chars[i]);
//        }
    }
}
