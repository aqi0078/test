package com.zdz.test.web.controller;

import com.zdz.test.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * spring boot+JPA
     */
    @Autowired
    HelloService helloService;
    @RequestMapping("/hello")
    public String hello(){
        helloService.sayHi();
        helloService.findList();
        return "hello------";
    }
    @RequestMapping("/insert")
    public String insert(){
        helloService.insert();
        return "hello------";
    }

    @RequestMapping("/page")
    public String page(){
        helloService.page();
        return "hello------";
    }
    @RequestMapping("/page1")
    public String page1(){
        helloService.getSomeWherePage("1",1);
        System.out.println("===========");
        helloService.getSomeWherePage("1",null);
        return "hello------";
    }
}
