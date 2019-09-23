package com.zdz.test.web.tool.scheduledJob;

import com.zdz.test.web.tool.aspect.logTrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-20
 */
@Slf4j
@Component
public class HelloJob {

    @Scheduled(cron = "* 0/10 * * * ?")
//    @Scheduled(cron = "0/10 * * * * ?")
//开启异步执行
    @Async
    public void pushDataScheduled1() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("定时任务1:{}",Thread.currentThread().getName());
    }
    @Scheduled(cron = "* 0/10 * * * ?")
//    @Scheduled(cron = "0/10 * * * * ?")
//开启异步执行
    @Async
    public void pushDataScheduled2() {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("定时任务2:{}",Thread.currentThread().getName());
    }
    @Scheduled(cron = "* 0/10 * * * ?")
//    @Scheduled(cron = "0/10 * * * * ?")
//开启异步执行
    @Async
    public void pushDataScheduled3() {
        try {
            Thread.sleep(56);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("定时任务3:{}",Thread.currentThread().getName());
    }
}
