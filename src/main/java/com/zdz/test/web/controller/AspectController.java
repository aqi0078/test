package com.zdz.test.web.controller;

import com.zdz.test.web.service.AspectService;
import com.zdz.test.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AspectController {
    @Autowired
    AspectService aspectService;
    @RequestMapping("/aspect")
    public String aspect(){
        return aspectService.test("成功");
    }
}
