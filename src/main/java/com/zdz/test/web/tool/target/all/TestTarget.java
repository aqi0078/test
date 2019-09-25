package com.zdz.test.web.tool.target.all;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-23
 */

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestTarget {
        String value() default "";
}
