package com.zdz.test.test.tmp;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-19
 */
public class G {
//
//    static final ThreadPoolExecutor pool=new ThreadPoolExecutor(1,10,0, TimeUnit.MINUTES,
//            new LinkedBlockingQueue<Runnable>());//线程池

    static final ThreadPoolExecutor pool=new ThreadPoolExecutor(1,10,0, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(1));//线程池
    public static void main(String[] args) {

        pool.execute(new RepayNotify(1));
        pool.execute(new RepayNotify(2));
        pool.execute(new RepayNotify(3));
    }

    public static class RepayNotify implements Runnable{
    int i=0;
    public RepayNotify(int i){
        this.i= i;
    }
        @Override
        public void run() {
            System.out.println(i+"==="+Thread.currentThread().getName());

            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
