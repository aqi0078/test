package com.zdz.test.web.tool.target;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author zhangdezhi
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface TestLock {

    String value() default "";
}
