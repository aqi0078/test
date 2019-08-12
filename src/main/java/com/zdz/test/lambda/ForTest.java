package com.zdz.test.lambda;

import java.util.ArrayList;
import java.util.List;

public class ForTest {

    public static void main(String[] args) {
        List<String> list=getData();
        list.forEach(str->{
            if (str.equals("2")){
                System.out.println(str);
            }
        });
        list.stream().forEach(str->{
            System.out.println(str);
        });

    }
    public static List<String> getData() {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        return list;
    }

}
