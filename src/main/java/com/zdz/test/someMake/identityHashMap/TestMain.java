package com.zdz.test.someMake.identityHashMap;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-10-08
 */
public class TestMain {

    public static void main(String[] args) {
        Map<String,Integer>map=new IdentityHashMap<>();
        map.put(new String("a"),1);
        map.put(new String("a"),2);
        map.put(new String("a"),3);
        System.out.println(map.size());
    }
}
