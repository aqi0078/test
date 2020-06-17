package com.zdz.test.test.tmp;

import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangdezhi
 * @date 2020-04-09
 */
public class Test20200409 {
    public static String parseDate2Sring(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
    private static String recommendNum(String uid){
        Integer id=Integer.valueOf(uid);
        id =Integer.valueOf(id+""+ 23) ;
        return Long.toHexString(id).toUpperCase();
    }
    public static void main(String[] args) throws Exception {

        List<Integer> list=new ArrayList();
        System.out.println(list.isEmpty());


        list=null;
        for (Integer i:list) {
            System.out.println("=============");
        }
        Thread t=new Thread();
        t.join();
        System.out.println(recommendNum("15593833"));
        System.out.println(recommendNum("15593841"));
        System.out.println(recommendNum("02"));
        System.out.println(recommendNum("00").toUpperCase());
//        System.out.println(Long.toHexString(Long.valueOf(System.currentTimeMillis()))+"1234");
//        System.out.println(Long.toHexString(Long.valueOf(99999999)));
//        Integer panelType;
//        String str="A";
//        switch (str){
//            case "A":panelType=1;break;
//            case "B":panelType=2;break;
//            case "C":panelType=3;break;
//            case "D":panelType=4;break;
//            case "S":panelType=5;break;
//            default:
//                panelType = 6;
//        }
//
//        System.out.println(panelType);








//        String s=null;
//        if ("s".equals(s)){
//            System.out.println("ssssss");
//        }
//        List<String> list=new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        Iterator<String> iterator1=list.iterator();
//        Iterator<String> iterator2=list.iterator();
//        iterator1.next();
//        iterator1.remove();
//        iterator2.next();

//        System.out.println("a5b43cq2w".toUpperCase().toUpperCase());
//        System.out.println(Long.parseLong("8CBB658", 16));
//        System.out.println(new Date(1588160391464L));
//        System.out.println((System.currentTimeMillis() - 1588160391464L) / (60 * 60 * 1000) > (10 * 24));
//        HashMap map=new HashMap();
//        map.put("1",1);
//        map.remove("1");
//        System.out.println(System.currentTimeMillis());
//        Long ll=(System.currentTimeMillis()<<3);
//        System.out.println(ll>>3);
//        System.out.println(System.currentTimeMillis());
//        System.out.println(Long.toHexString(System.currentTimeMillis()));
//        System.out.println(Long.toHexString(System.currentTimeMillis()/1000));
//        System.out.println(Long.valueOf(Integer.valueOf(1999999+""+10)));
//        System.out.println(Long.toHexString(Long.valueOf(Integer.valueOf(1999999+""+10))).toUpperCase());

//        Map<String, List> map=new HashMap<>();
//        List list1=new ArrayList();
//        list1.add(211);
//        list1.add(212);
//        list1.add(213);
//        List list2=new ArrayList();
//        list2.add(10);
//        list2.add(90);
//        list2.add(0);
//        map.put("gift",list1);
//        map.put("chance",list2);
//        System.out.println(JSON.toJSONString(map));
//        System.out.println(JSON.parseObject(JSON.toJSONString(map),Map.class).get("1"));
//
//        Random r = new Random();
//        int i=r.nextInt(1);
//
//        System.out.println(i);
//        System.out.println(r.nextInt(1));
//        System.out.println(r.nextInt(1));
//        System.out.println(System.currentTimeMillis()%100000000);
//
//        System.out.println(parseDate2Sring(new Date(),"MMddHHmmssSSS"));
//        System.currentTimeMillis();
//        System.out.println(System.currentTimeMillis());
//        System.out.println(Long.toHexString(System.currentTimeMillis()));
//
//        System.out.println(Integer.toHexString(12316521));
//        System.out.println(Integer.toHexString(1235652));
//        System.out.println(Integer.toHexString(123652));
//
//        System.out.println(Long.toHexString(Long.valueOf(Integer.toOctalString(123))));
//        System.out.println(Long.toHexString(Long.valueOf(Integer.toOctalString(22345678))));
//
//        System.out.println("8============ "+Long.valueOf(Integer.toOctalString(22345678)));
//        String s16=Long.toHexString(Long.valueOf(Integer.toOctalString(22345678)));
//        System.out.println("16--->8============ "+Long.parseLong(s16, 16));
//        String st8r=Integer.toOctalString(22345678).toString();
//        System.out.println(Integer.parseInt(st8r, 8));

//        Long s=Long.parseLong(Long.toHexString(Long.valueOf(Integer.toOctalString(22345678))), 16);

//        List<Integer>list=null;
//        for (Integer i:list ) {
//            System.out.println("22222222222222");
//        }
//        HashMap map=new HashMap();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.getTime());
//        ConcurrentHashMap map=new ConcurrentHashMap(32);
//        map.put("","");
//        System.out.println(new Date(1587288157000L));
//        Long s=Long.parseLong("31e1dae", 16);
//        Integer re=Integer.parseInt(s.toString(), 8);
//        System.out.println(re);
//
//
//        Calendar calendar = Calendar.getInstance();
//        int week = calendar.get(Calendar.HOUR_OF_DAY);
//        System.out.println(week);
    }
}
