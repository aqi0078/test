package com.zdz.test.web.tool.dingding;

public class TestMain {
    public static void main(String[] args) {
        MarkdownMessage msg = new MarkdownMessage();
        msg.setTitle("ss");
        msg.add("ssssss");
        DingDingRobotServiceImpl dd=new DingDingRobotServiceImpl();
        dd.sendXXDingDing("钉钉地址",msg);
    }
}
