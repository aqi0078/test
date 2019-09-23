package com.zdz.test.web.tool.aspect.logTrace;

import com.zdz.test.web.tool.filter.LogConstant;
import com.zdz.test.web.tool.filter.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.CharacterPredicates;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-20
 */
@Aspect
@Component
@Slf4j
public class LogTraceAspect {


    private static final RandomStringGenerator
            generator = new RandomStringGenerator.Builder().withinRange(65, 122).filteredBy(
            CharacterPredicates.DIGITS, CharacterPredicates.LETTERS).build();


    @Pointcut("@annotation(com.zdz.test.web.tool.aspect.logTrace.LogTrace)")
    public void methodAspect() {
    }

    @Pointcut("@annotation(org.springframework.scheduling.annotation.Async)")
    public void asyncAspect() {
    }

    @Before(value = "methodAspect() && @annotation(logTrace)")
    public void doBefore(LogTrace logTrace) {
        addTraceId();
    }

    @Before(value = "asyncAspect() && @annotation(async)")
    public void doAsyncBefore(Async async) {
        addTraceId();
    }

    @AfterReturning(value = "methodAspect() && @annotation(logTrace)", returning = "result")
    public void doAfter(LogTrace logTrace, Object result) {
        removeTraceId();
    }

    @AfterReturning(value = "asyncAspect() && @annotation(async)", returning = "result")
    public void doAsyncAfter(Async async, Object result) {
        removeTraceId();
    }

    @AfterThrowing(value = "methodAspect()", throwing = "e")
    public void doAfterEx(Exception e) {
        removeTraceId();
    }

    @AfterThrowing(value = "asyncAspect()", throwing = "e")
    public void doAsyncAfterEx(Exception e) {
        removeTraceId();
    }

    private void removeTraceId() {
        TraceIdUtil.removeTraceId();
        MDC.remove(LogConstant.X_B3_TraceId);
        MDC.remove(LogConstant.X_B3_SpanId);
    }

    private void addTraceId() {
        //如果MDC中不存在traceId，则自行生成并删除
        if (StringUtils.isBlank(MDC.get(LogConstant.X_B3_TraceId))
                && StringUtils.isBlank(TraceIdUtil.getTraceId())) {
            String traceId = generator.generate(10);
            MDC.put(LogConstant.X_B3_TraceId, traceId);
            MDC.put(LogConstant.X_B3_SpanId, traceId);
        }
    }
}
