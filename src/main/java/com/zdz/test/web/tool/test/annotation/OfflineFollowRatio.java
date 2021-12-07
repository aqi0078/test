package com.zdz.test.web.tool.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 线下喊单放大-方法注解
 *
 * @author lh
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//@Document
public @interface OfflineFollowRatio {

  /**
   * 字段名称
   *
   * @return name
   */
  String[] names();
}
