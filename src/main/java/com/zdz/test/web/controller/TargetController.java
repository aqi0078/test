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
        targetBean.setData("lulu");
//        String str=targetService.test(targetBean);
        targetBean.setData("lulu@qq.com");
        String str= targetService.test(targetBean);
        return str;
    }
    @RequestMapping("/targetAll")
    public String targetAll(){
        TargetBean targetBean=new TargetBean();
        targetBean.setData("lulu");
//        String str=targetService.test(targetBean);
        targetBean.setData("lulu@qq.com");
        targetService.testAll();
        targetService.testAll1(targetBean);
        return "Hi~~";
    }
}
