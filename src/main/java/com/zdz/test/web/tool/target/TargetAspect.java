package com.zdz.test.web.tool.target;

import com.zdz.test.web.bean.TargetBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class TargetAspect {


    @Pointcut("@annotation(com.zdz.test.web.tool.target.TestLock)")
    private void testLock () {
    }

    @Around("testLock()")
    private Object statTestLock(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("======注解方法开始====");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TestLock testLock=method.getAnnotation(TestLock.class);
        String value=testLock.value();
        log.info("===注解方法参数："+value);

        Object[] arrays=joinPoint.getArgs();
        TargetBean targetBean= (TargetBean) arrays[0];

        Field[] fields =arrays[0].getClass().getDeclaredFields();

        
        for (Field field : fields) {
            field.setAccessible( true );
            if(field.isAnnotationPresent(FieldTarget.class)){
                FieldTarget fieldTarget=field.getAnnotation(FieldTarget.class);
                String str=fieldTarget.value();
                log.info("==str===="+str);
                field.getName();
                log.info("==field.getName()===="+field.getName());
                field.get(targetBean);
                log.info("==str===="+field.get(targetBean));
            }
        }

        
        Object obj = null;
        obj = joinPoint.proceed();
        log.info("======注解方法结束====");
        return obj;
    }
}
