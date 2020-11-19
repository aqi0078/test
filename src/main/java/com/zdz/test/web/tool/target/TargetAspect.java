//package com.zdz.test.web.tool.target;
//
//import com.zdz.test.web.bean.TargetBean;
//import com.zdz.test.web.tool.regEx.RegEx;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//
//@Slf4j
//@Aspect
//@Component
//public class TargetAspect {
//
//
//    @Pointcut("@annotation(com.zdz.test.web.tool.target.TestLock)")
//    private void testLock () {
//    }
//
//    @Around("testLock()")
//    private Object statTestLock(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("======注解方法开始====");
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        TestLock testLock=method.getAnnotation(TestLock.class);
//        String value=testLock.value();
//        log.info("===注解方法参数："+value);
//
//        Object[] arrays=joinPoint.getArgs();
//        TargetBean targetBean= (TargetBean) arrays[0];
//
//        Field[] fields =arrays[0].getClass().getDeclaredFields();
//
//
//        for (Field field : fields) {
//            field.setAccessible( true );
//            if(field.isAnnotationPresent(FieldTarget.class)){
//                FieldTarget fieldTarget=field.getAnnotation(FieldTarget.class);
//                //获取注解的值
//                String str=fieldTarget.value();
//                log.info("==str===="+str);
//                //获取参数名称
//                field.getName();
//                log.info("==field.getName()===="+field.getName());
//                //获取参数的值
//                log.info("==str= ==="+field.get(targetBean));
//
//
//                //正则表达式
//                String format=fieldTarget.format();
//                log.info("==format===="+format);
//                if (!"".equals(format)){
//                    boolean isTrue=RegEx.isTrue(format,field.get(targetBean).toString());
//                    log.info("==isTrue===="+isTrue);
//                    if (!isTrue){
//                        return "lalallala";
//                    }
//                }
//            }
//        }
//
//
//        Object obj = null;
//        obj = joinPoint.proceed();
//        log.info("======注解方法结束====");
//        return obj;
//    }
//}
