package com.zdz.test.test.tmp;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdezhi
 */
public class A {
    public static void main(String[] args) {

        Integer i=0;
        CardType d=null;
        int d1=d.ordinal();
        String str="{\"data\":103118454,\"type\":\"LOAN_SUCCESS\"}";
        Map<String,String> map=new HashMap<>();
        map.put("data","103118454");
        JSONObject json1 = JSONObject.parseObject(str);
        Long data0 = json1.getObject("data", Long.class);
        System.out.println(data0);
        JSONObject json = JSONObject.parseObject(JSON.toJSON(map).toString());
        Long data = json.getObject("data", Long.class);
        System.out.println(data);
        Long data1 = json.getObject("ab", Long.class);
        System.out.println(data1);
//        StringBuilder sbu=new StringBuilder();
//        StringBuffer stringBuffer=new StringBuffer();
//        stringBuffer.append(1);
//        sbu.append(1);
//        A2 a1=new A2();
//        A1 a2=new A2();
//        A1 a3=new A3();
//
//        a1.getA(new A1());
//        a1.getA(new A2());
//        a1.getA(new A3());
//        a2.getA(new A1());
//        a2.getA(new A2());
//        a2.getA(new A3());
//        a3.getA(new A1());
//        a3.getA(new A2());
//        a3.getA(new A3());
//        for (int i = 0; i < 10; i++) {
//            System.out.println((2<<i)*100);
//        }
//        System.out.println(new Date().getTime());


    }
}
