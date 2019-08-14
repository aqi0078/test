package com.zdz.test.web.controller;

import com.zdz.test.web.bean.TargetBean;
import com.zdz.test.web.service.AspectService;
import com.zdz.test.web.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TargetController {
    @Autowired
    TargetService targetService;
    @RequestMapping("/target")
    public String target(){
        TargetBean targetBean=new TargetBean();
        targetService.test(targetBean);
        return "succ";
    }
}
