package com.zdz.test.test.tmp;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-23
 */
public class A2 extends A1{
//    static {
//        System.out.println("A2 static");
//    }
//    public A2(){
//        System.out.println("A2 ()");
//    }
//    {
//
//        System.out.println(" 2()");
//    }

    @Override
    public void getA(A2 a2){
        System.out.println("A2A2");
    }
    @Override
    public void getA(A3 a3){
        System.out.println("A2A3");
    }

}
