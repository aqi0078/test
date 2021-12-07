package com.zdz.test.test.tmp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Date: 2021/3/31
 */
public class Test20210331 {
    public static void main(String[] args) {
//        BigDecimal tmp = BigDecimal.ZERO;
//        for (int i = 0; i < 10; i++) {
//           tmp.add(BigDecimal.ONE);
//        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        String type = "phone";
        String str = "";
        switch (type){
            case "phone":str = "ALL_WAREHOUSE_WARN_PHONE";break;
        }
        System.out.println(str);
//        list.stream().filter(integer -> integer>3).collect(Collectors.toList());
//        System.out.println(list);
//        System.out.println(BigDecimal.ONE.divide(new BigDecimal("0.6666666"), 4, RoundingMode.DOWN));

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1,1);
//        System.out.println(map.containsKey(1));
//        System.out.println(map.containsKey(2));
//
//        BigDecimal tmp = new BigDecimal("1.000000000");
//        BigDecimal tmp1 = new BigDecimal("1");
//        System.out.println(aa(0));
//        System.out.println(tmp.compareTo(tmp1) == 0);
//        System.out.println(tmp);
//        System.out.println(tmp.stripTrailingZeros());
//        System.out.println(tmp.stripTrailingZeros().scale());
    }

//    public static int aa(int data){
//        switch (data){
//            case 0:return 0;
//            case 1:return 1;
//        }
//        if (data == 0){
//            return 3;
//        }
//        return 4;
//    }
}
