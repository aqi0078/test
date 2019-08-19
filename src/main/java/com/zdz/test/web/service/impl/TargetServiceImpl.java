package com.zdz.test.web.service.impl;

import com.zdz.test.web.bean.TargetBean;
import com.zdz.test.web.service.TargetService;
import com.zdz.test.web.tool.target.TestLock;
import org.springframework.stereotype.Service;

import com.zdz.test.web.service.TargetService;

@Service("targetService")
public class TargetServiceImpl implements TargetService {

    @Override
    @TestLock(value ="value")
    public String test(TargetBean targetBean){
        System.out.println("====targetService====");
        return targetBean.getData();
    }
}
