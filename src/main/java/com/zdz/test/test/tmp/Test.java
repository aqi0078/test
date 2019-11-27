package com.zdz.test.test.tmp;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

//        if(null ==2){
//
//        }
        List<String> str=new ArrayList<>();
        str.add("1");
        System.out.println(str.contains("1"));
        System.out.println(str.contains("2"));
        List<B> list=new ArrayList<>();
        System.out.println(list.size());
        maan(list);
        System.out.println(list.size());
    }

    public static void maan(List<B> list) {
        B b=new B();
        list.add(b);
    }
}
