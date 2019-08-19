package com.zdz.test.web.tool.target;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author zhangdezhi
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface FieldTarget {

    String value() default "";
    String format() default "";
}
