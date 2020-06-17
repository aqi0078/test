package com.zdz.test.test.tmp;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhangdezhi
 * @date 2020-03-04
 */
public class Test20200304 {
    public static void main(String[] args) {
        String str="VIP_FREE,FEE";
        str.concat("fee");
        System.out.println(str.indexOf("fee"));
        System.out.println(str.indexOf("FEE"));

       // VIP_YW   VIP_YW
        // VIP_CP   VIP_CP
        // QG   QG
        // VFREE   VIP_FREE
        // VIP_FREE   VIP_FREE
        // FEE   VIP_YW

        System.out.println(str.replaceAll("FEE","VIP_YW"));
        str.replaceAll("FEE","VIP_YW");
        str.replaceAll("VFREE","VIP_FREE");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("a","a");
        jsonObject.get("a");
        jsonObject.put("a","b");
        System.out.println(jsonObject);











    }
}
