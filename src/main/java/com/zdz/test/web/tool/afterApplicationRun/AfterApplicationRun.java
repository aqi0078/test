package com.zdz.test.web.tool.afterApplicationRun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Slf4j
//把普通pojo实例化到spring容器中
@Component
//多个的时候按order的设定顺序，有小到大
@Order(value=1)
public class AfterApplicationRun implements CommandLineRunner {
    @Override
    public void run(String... args) {
        log.info("========启动预加载1=========");
    }
}
