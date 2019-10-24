//package com.zdz.test.web.tool.mybatisInterceptor;
//
//import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Author: ZhangDeZhi
// * @Date: 2019-10-23
// */
//@Configuration
//public class MybatisConfig {
//    @Bean
//    ConfigurationCustomizer mybatisConfigurationCustomizer() {
//        return new ConfigurationCustomizer() {
//            @Override
//            public void customize(org.apache.ibatis.session.Configuration configuration) {
//                configuration.addInterceptor(new MyPageInterceptor());
//            }
//        };
//    }
//}
