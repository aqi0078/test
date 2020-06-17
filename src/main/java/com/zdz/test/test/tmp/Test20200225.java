package com.zdz.test.test.tmp;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangdezhi
 * @date 2020-02-25
 */
public class Test20200225 {
    public class Key{

        public String getKey(String uid,String pan,String date){
            String key="";
            if (StringUtils.isNotEmpty(uid)){
                key=key+uid+":";
            }
            if (StringUtils.isNotEmpty(pan)){
                key=key+pan+":";
            }
            if (StringUtils.isNotEmpty(date)){
                key=key+date+":";
            }
            return key=key;
        }
    }
    public enum Data{
        a("info1"),
        b("info2");
        private String info;
        private Data(String info){
            this.info=info;
        }
        public String getInfo(){
            return info;
        }
    }

    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(JSON.toJSONString(list));
        list.remove(5);
        list.add(5,6);
        System.out.println(JSON.toJSONString(list));
        Integer str=0;
//        Long sb=(Long)str;
        Data[] data=Data.values();
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i].name());
            System.out.println(data[i].getInfo());
            ;
//            System.out.println(data[i].getKey(null,"pan","2020-02-25"));
        }
        Map<Integer, Map<String,String>> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        map1.put(1,map2);
        map2.put("A","答案不是B");
        map2.put("B","选择C是答案");
        map2.put("C","选择B说的对");
        map2.put("D","你说谁是答案");
        String sb=JSON.toJSONString(map1);
        System.out.println(sb);
        Map<Integer, Map<Integer,String>> map= JSON.parseObject(sb,Map.class);
        System.out.println(map.get(1).get(1));
    }
}
