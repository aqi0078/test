package com.zdz.test.web.service.impl;

import com.zdz.test.web.service.AspectService;
import org.springframework.stereotype.Service;

import com.zdz.test.web.service.AspectService;

@Service("aspectService")
public class AspectServiceImpl implements AspectService {
    @Override
    public String test(String data){
        System.out.println("=====--==="+data);
        return data;
    }
}
