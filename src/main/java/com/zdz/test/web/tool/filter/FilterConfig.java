package com.zdz.test.web.tool.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-20
 */
@Configuration
public class FilterConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE + 7)
    public Filter apiLogFilter() {
        return new LogFilter();
    }
}
