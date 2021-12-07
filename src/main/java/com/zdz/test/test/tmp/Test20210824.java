package com.zdz.test.test.tmp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Date: 2021/8/24
 */
public class Test20210824 {

    public static void main(String[] args) {

        Long[] id = {196211L,196232L,196242L,196256L,196303L,196320L,196331L,196339L,196348L,196358L};
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i > 0 ; i--) {
            list.add(i);
        }
//        list.sort((a1,a2) -> a1.compareTo(a2));
        list.sort(Integer::compareTo);
        System.out.println(list);

        System.out.println("ss".equals(null));
    }
}
