package com.zdz.test.web.service.impl;

import com.zdz.test.web.bean.Info;
import com.zdz.test.web.mapper.HelloRepository;
import com.zdz.test.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {
    @Autowired
    HelloRepository helloRepository;
    @Override
    public void sayHi() {
        Info info=helloRepository.findByIdEquals(1L);
        System.out.println("====say hi====="+info.getName());
    }
}
