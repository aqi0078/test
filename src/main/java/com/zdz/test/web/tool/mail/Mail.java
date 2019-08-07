package com.zdz.test.web.tool.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    private String geUsername="aqi0078@sina.com";
    private String geHost="smtp.sina.com";
    private int gePort=25;
    private String gePassword="33502f3343982455";//33502f3343982455



    public JavaMailSender mailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setUsername(geUsername);
        javaMailSender.setHost(geHost);
        javaMailSender.setPort(gePort);
        javaMailSender.setDefaultEncoding("UTF-8");
        javaMailSender.setPassword(gePassword);
        Properties prop = new Properties() ;
        // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.auth", "true") ;
        prop.put("mail.smtp.timeout", "25000") ;
        javaMailSender.setJavaMailProperties(prop);
        return javaMailSender;
    }
    @Autowired
    private JavaMailSenderImpl sender;

    public void send(String to,String subject,String message){
        JavaMailSenderImpl sender =((JavaMailSenderImpl)mailSender());
        MimeMessage mailMessage = sender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);
        try {
            //设置收件人，寄件人\
            messageHelper.setTo(to);
            messageHelper.setFrom(sender.getUsername());
            messageHelper.setSubject(subject);
            //true 表示启动HTML格式的邮件
            messageHelper.setText(message, true);
        } catch (MessagingException e) {
            System.out.println("邮件发送失败：");
        }
        sender.send(mailMessage);
        System.out.println("邮件发送成功:{}");
    }



}
