package com.zdz.test.test.tmp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class F {
    public static final int GRADE=10;//梯度级数
    public static final int ONETIME=300;//时间片大小
    public static final int COUNT=5;//步长，每个线程执行的数量
    public static AtomicInteger INDEX=new AtomicInteger(0);//起点，每个线程步长起点
    public static final int POOLSIZE=10;//线程数
    static final ThreadPoolExecutor pool=new ThreadPoolExecutor(POOLSIZE,POOLSIZE,0, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>());//线程池
    public static List<String> list=new ArrayList<>();
    public static final AtomicInteger SUM=new AtomicInteger(0);//运行总数量
    public static boolean isRunning=false;
    public static void main(String[] args) {
        for (int i = 0; i < 98; i++) {
            list.add(""+i);
        }
        running();
        running();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(isRunning);
        running();



    }

    public static void running(){
        if(isRunning){
            System.out.println("任务正在运行中……");
            return;
        }
        isRunning=true;
        for (int j = 0; j < list.size()/COUNT+1; j++) {
            System.out.println("==00"+j);
            pool.execute(new RepayNotify(list,INDEX.getAndAdd(COUNT),COUNT));
        }
    }
    public static class RepayNotify implements Runnable{
        List<String> list=null;//数据源
        int index=0;//数据起点
        int count=0;//数据终点
        public RepayNotify(List<String> list, int index, int count){
            this.list=list;
            this.index=index;
            this.count=index+count;
            if(this.count>list.size()){
                this.count=list.size();
            }
        }
        @Override
        public void run() {
            for (int i = index; i < count; i++) {
                //执行通知
                //通知失败加入下一级的list
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+"==="+list.get(i));

                SUM.incrementAndGet();

            }
            if(SUM.get()==list.size()){
                isRunning=false;
                INDEX=new AtomicInteger(0);
            }
        }
    }
}
