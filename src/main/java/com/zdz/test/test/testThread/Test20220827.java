package com.zdz.test.test.testThread;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zdz.test.test.tmp.AccountLiquidationFlow;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Description:
 * @Date: 2021/8/27
 */
public class Test20220827 {
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    public static Date getCurrentWeekDayEndTime() {
        Calendar c = Calendar.getInstance();

        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK);
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.add(Calendar.DATE, 8 - weekday);

            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));

        } catch (Exception e) {
            e.printStackTrace();

        }

        return c.getTime();

    }

    public static long getDayTime(long ts){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(ts));
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }
    public static long getMonthTime(long ts){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(ts));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTimeInMillis();
    }



    public static void main1(String[] args){

        Long time = 27210479L;
        System.out.println(time/60%12);
        System.out.println(time/60%8);
        long s = getDayTime(time*60*1000)/1000/60;
        Long data = time - s > 12*60 ? s + 12*60: s;
        System.out.println(data);
    }

    public static void testForDate(){
//规定返回日期格式
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        Date theDate=calendar.getTime();
        GregorianCalendar gcLast=(GregorianCalendar)Calendar.getInstance();
        gcLast.setTime(theDate);
//设置为第一天
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first=sf.format(gcLast.getTime());
//打印本月第一天
        System.out.println(day_first);
    }
    public static void main(String[] args) throws InterruptedException {

//        Long a = 99999999999L;
//        System.out.println(getMonthTime());
        Long time = 27210481L;
//        System.out.println(27210479%720);
//        System.out.println(27210479%480);
        testForDate();
        System.out.println();
        long ts = time*60*1000;
//        System.out.println(getDayTime(ts));
        System.out.println(longSdf.format(new Date(getDayTime(ts))) );
        Long a =  27232139L;
        Long b =  27232139L;
        System.out.println(a.compareTo(b) > 0);
        UpdateKLineTypeEnum[] typeEnums = UpdateKLineTypeEnum.values();
//        for (UpdateKLineTypeEnum typeEnum : typeEnums) {
//            System.out.println(typeEnum.name() + "--" + time%typeEnum.getTime());

//            System.out.println(typeEnum.name() + "--" + time%typeEnum.getTime());
//            long first = time - time%typeEnum.getTime();
//            long end = first + typeEnum.getTime();
//            System.out.println(typeEnum.name() + "--first:" + first*60*1000 +
//                    "--end:" + end*60*1000 );
//            System.out.println(typeEnum.name() + "--first:" + longSdf.format(new Date(first*60*1000)) +
//                    "--end:" + longSdf.format(new Date(end*60*1000)) );
//

//            switch (typeEnum){
//                case MIN1:
//                case MIN5:
//                case MIN15:
//                case MIN30:
//                    System.out.println(typeEnum.name() + "--first:" +
//                            longSdf.format(new Date((time - time%typeEnum.getTime())*60*1000)) +
//                            "--end:" + longSdf.format(new Date((time - time%typeEnum.getTime()+ typeEnum.getTime())*60*1000)) );
//                    break;
//                case HOUR1:
//                case HOUR4:
//                case HOUR8:long timeTime = time/60;
//                    System.out.println(typeEnum.name() + "--first:" +
//                            longSdf.format(new Date((timeTime - timeTime%(typeEnum.getTime()/60))*60*60*1000)) +
//                            "--end:" + longSdf.format(new Date((timeTime - timeTime%(typeEnum.getTime()/60)+ typeEnum.getTime()/60)*60*60*1000)) );
//                    break;
//                case HOUR12:
//                    long s = getDayTime(time*60*1000)/1000/60;
//                    Long data = time - s > 12*60 ? s + 12*60: s;
//                    System.out.println(typeEnum.name() + "--first:" + longSdf.format(new Date(data*60*1000))+
//                            "--end:" + longSdf.format(new Date((data + 12*60)*60*1000)));
//                    break;
//                case DAY:
//                    System.out.println(typeEnum.name() + "--first:" + longSdf.format(new Date(getDayTime(ts)))+
//                            "--end:" + longSdf.format(new Date(getDayTime(ts) + 24*60*60*1000)));
//                    break;
//                case MONTH:
//                    System.out.println(typeEnum.name() + "--first:" + longSdf.format(new Date(getMonthTime(ts)))+
//                            "--end:" + longSdf.format(new Date(getMonthTime(ts) + 7*24*60*60*1000)));
//                    break;
//            }
        }
//        ThreadPoolExecutor threadPoolExecutor =
//                new ThreadPoolExecutor(
//                        0,
//                        4,
//                        120,
//                        TimeUnit.SECONDS,
//                        new ArrayBlockingQueue(10),
//                        new ThreadFactoryBuilder().setNameFormat("member-level-grade-%d").build(),
//                        new ThreadPoolExecutor.CallerRunsPolicy());
//
//        while (true) {
//            CountDownLatch countDownLatch = new CountDownLatch(50);
//            for (int i = 0; i < 50; i++) {
//                threadPoolExecutor.execute(() -> {
//                    if (countDownLatch.getCount() == 1) {
//                        System.out.println("xxx");
//                    }
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        System.err.println(Thread.currentThread().getName() + "=0000000000=" + countDownLatch.getCount());
//                        e.printStackTrace();
//                    }
//                    countDownLatch.countDown();
//                    System.err.println(Thread.currentThread().getName() + "==" + countDownLatch.getCount());
//                });
//            }
//            countDownLatch.await();
//            System.out.println("执行完了");
//        }
//        String s = 1+"-"+"sji";
//        String[] str = s.split("-");
//        System.out.println(str.length);
//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Map<Integer,Integer>> map =new HashMap<>();
//        map.computeIfAbsent(1, integer -> new HashMap<>()).put(2,3);
//        System.out.println(map);
//        map.computeIfAbsent(1, integer -> new HashMap<>()).put(2,4);
//        System.out.println(map);
//        AccountLiquidationFlow flow = new AccountLiquidationFlow();
//        flow.setAccountId(1L);
//        flow.setInsurance(BigDecimal.TEN);
//        flow.setIsolated(true);
//        flow.setSeq("1");
//
//        System.out.println(flow);
//        AccountLiquidationFlow flow1 = flow.clone();
//        flow1.setAccountId(2L);
//        flow1.setInsurance(BigDecimal.ONE);
//        flow1.setIsolated(false);
//        flow1.setSeq("2");
//        System.out.println(flow1);
//        AccountLiquidationFlow flow2=flow;
//        System.out.println(flow2);


//        System.out.println(13>>40);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        List<CompletableFuture<A>> completableFutures = Lists.newCopyOnWriteArrayList();
//        completableFutures.add(runing(1));
//        completableFutures.add(runing(2));
//        CompletableFuture<Integer> num = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).
//                thenApplyAsync(aVoid -> {
//                    completableFutures.forEach(aCompletableFuture -> {
//                        System.out.println(aCompletableFuture.join().getNum());
//                    });
//                    return -1;
//        });
//        Integer a = num.join();
//
//        System.out.println(a);


//    public static CompletableFuture runing(Integer i) {
//        return CompletableFuture.supplyAsync(() ->{
//            return new A(i);
//        });
//    }

}
