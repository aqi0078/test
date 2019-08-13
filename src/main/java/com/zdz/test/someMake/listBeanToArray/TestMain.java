package com.zdz.test.someMake.listBeanToArray;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List<Bean> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Bean bean=new Bean();
            bean.setAge(i);
            bean.setName(String.valueOf(i));
            list.add(bean);
        }
        Bean[] beans=list.toArray(new Bean[list.size()]);
        for (int i = 0; i < beans.length; i++) {
            System.out.println(beans[i].getAge());
            System.out.println(beans[i].getName());
            System.out.println("==========");
        }
    }
}
