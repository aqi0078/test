//package com.zdz.test.web.tool.redisson;
//
//import org.redisson.Redisson;
//import org.redisson.api.RBlockingQueue;
//import org.redisson.api.RDelayedQueue;
//import org.redisson.api.RQueue;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.SimpleFormatter;
//
//public class TestMain2 {
//    Config config = new Config();
//         config.useSingleServer().setAddress("redis://192.168.19.173:6379").setPassword("ps666").setDatabase(2);
//    RedissonClient redissonClient = Redisson.create(config);
//    RBlockingQueue<CallCdr> blockingFairQueue = redissonClient.getBlockingQueue("delay_queue");
//    RDelayedQueue<CallCdr> delayedQueue = redissonClient.getDelayedQueue(blockingFairQueue);
//         while (true){
//        CallCdr callCdr = null;
//        try {
//            callCdr = blockingFairQueue.take();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("订单取消时间："+new SimpleDateFormat("hh:mm:ss").format(new Date())+"==订单生成时间"+callCdr.getPutTime());
//
//    }
//
//}
//}
