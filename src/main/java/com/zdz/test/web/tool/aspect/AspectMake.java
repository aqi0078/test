package com.zdz.test.web.tool.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectMake {


    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.zdz.test.web.service.impl.AspectServiceImpl.*(..))")
    private void authAspect() {
    }

    @Around("authAspect()")
    private Object authCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("======切面开始====");
        Object[] objArray=joinPoint.getArgs();
        for (int i = 0; i < objArray.length; i++) {
            log.info("切面参数："+objArray[i]);
            return "失败";
        }
        Object obj = null;
        obj = joinPoint.proceed();
        log.info("======切面结束====");
        return obj;
    }
}
