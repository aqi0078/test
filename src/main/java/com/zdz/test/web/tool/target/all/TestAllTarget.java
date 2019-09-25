package com.zdz.test.web.tool.target.all;

import com.zdz.test.web.tool.aspect.logTrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-23
 */
@Slf4j
@Aspect
@Component
public class TestAllTarget {
    @Pointcut("@annotation(com.zdz.test.web.tool.target.all.TestTarget)")
    private void testTarget() {
    }

    /**
     * 环绕
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("testTarget()")
    private Object statTestLock(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("======TestTarget-Around注解开始====");
        Object obj = null;
        obj = joinPoint.proceed();
        log.info("======TestTarget-Around注解结束====");
        return obj;
    }

    /**
     * 前置通知
     */
    @Before(value = "testTarget()")
    public void doBefore() {
        log.info("======TestTarget-Before 注解开始====");
    }

    /**
     * 后置通知
     */
    @After(value = "testTarget()")
    public void doAfter() {
        log.info("======TestTarget-After 注解开始====");
    }

    @AfterReturning(value = "testTarget()", returning = "returnValue")
    public void log(JoinPoint point, Object returnValue) {
        log.info("@AfterReturning：模拟日志记录功能...");
        log.info("@AfterReturning：目标方法为：{}",
                point.getSignature().getDeclaringTypeName() +
                        "." + point.getSignature().getName());
        log.info("@AfterReturning：参数为：{}",
                Arrays.toString(point.getArgs()));
        log.info("@AfterReturning：返回值为：{}", returnValue);
        log.info("@AfterReturning：被织入的目标对象为：{}", point.getTarget());
    }

    @AfterThrowing(value = "testTarget()", throwing = "e")
    public void doAfterEx(Exception e) {
        log.info("@AfterThrowing：模拟日志记录功能...");
        log.info("@AfterThrowing：返回值为：{}", e.toString());
    }
}