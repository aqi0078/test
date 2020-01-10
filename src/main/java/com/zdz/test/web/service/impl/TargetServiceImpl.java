//package com.zdz.test.web.service.impl;
//
//import com.zdz.test.web.bean.TargetBean;
//import com.zdz.test.web.service.HelloService;
//import com.zdz.test.web.service.TargetService;
//import com.zdz.test.web.tool.aspect.logTrace.LogTrace;
//import com.zdz.test.web.tool.target.TestLock;
//import com.zdz.test.web.tool.target.all.TestTarget;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.zdz.test.web.service.TargetService;
//
//@Service("targetService")
//@Slf4j
//public class TargetServiceImpl implements TargetService {
//
//    @Autowired
//    com.zdz.test.web.service.HelloService helloService;
//    @Override
//    @TestLock(value ="value")
//    @LogTrace
//    public String test(TargetBean targetBean){
//        log.info("====targetService====");
//        helloService.sayHi();
//        return targetBean.getData();
//    }
//    @TestTarget
//    @Override
//    public String testAll(){
//        log.info("====testAll====");
//        return "Hi~~~~";
//    }
//    @TestTarget
//    @Override
//    public String testAll1(TargetBean targetBean){
//        log.info("====testAll1====");
//        if (1==1){
//            throw new RuntimeException();
//        }
//        return "Hi~~~~";
//    }
//}
