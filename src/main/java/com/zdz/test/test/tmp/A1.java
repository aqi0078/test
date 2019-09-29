package com.zdz.test.test.tmp;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-23
 */
@Getter
@Setter
public class A1 {
//    static {
//        System.out.println("A1 static");
//    }
//    public A1(){
//        System.out.println("A1 ()");
//    }
//    {
//
//        System.out.println(" ()");
//    }
BigDecimal b;


    public void getA(A1 a1){
        System.out.println("A1A1");
    }
    public void getA(A2 a2){
        System.out.println("A1A2");
    }
    public void getA(A3 a3){
        System.out.println("A1A3");
    }

}
