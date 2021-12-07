package com.zdz.test.test.tmp.test1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Description:
 * @Date: 2021/11/21
 */
public class A {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static String getLocalDateString(int n) {
        return LocalDate.now().plusDays((long) n).format(DATE_FORMATTER);
    }
    public static void main(String[] args) {

        System.out.println(getLocalDateString(-1));
//        Set<Integer> igInstrumentIdList = new HashSet<>();
//        igInstrumentIdList.add(100);
//        System.out.println(igInstrumentIdList.contains(10));
//        System.out.println(igInstrumentIdList.contains(100));
//        BigDecimal b1 = new BigDecimal("0.00000008");
//        System.out.println(new BigDecimal(b1.toPlainString()));
//        RebateData rebateData = new RebateData();
//        List<RebateData.Rebate> inviteRecord = new ArrayList<>();
//        RebateData.Rebate rebate = new RebateData.Rebate();
//        rebate.setRebate(new BigDecimal("0.8"));
//        inviteRecord.add(rebate);
//        rebateData.setInviteRecord(inviteRecord);
//        System.out.println(checkRebateData(rebateData));
//
//        System.out.println("checkRebateData(rebateData)".equals(null));
//        Long ll = 2021112323L;
//        if (ll <2021112500){
//            System.out.println("----------");
//        }
//        System.out.println(null.equals("null"));
    }
    public static boolean checkRebateData(RebateData rebateData){
        BigDecimal rate = BigDecimal.ZERO;
        for (RebateData.Rebate r : rebateData.getInviteRecord()) {
            rate = rate.add(r.getRebate());
        }
        return rate.compareTo(BigDecimal.ONE) <= 0;
    }
}
