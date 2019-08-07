package com.zdz.test.web.controller;

import com.zdz.test.web.tool.mail.Mail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @RequestMapping("/mail")
    public String mail(){

        Mail mail=new Mail();
        mail.send("@qq.com","cs","123AbC测试");
        return "hello------";
    }
}
