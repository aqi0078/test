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
        return "hello------";
    }

}
