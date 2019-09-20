package com.zdz.test.web.tool.aspect.logTrace;

import com.zdz.test.web.tool.filter.LogConstant;
import com.zdz.test.web.tool.filter.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.CharacterPredicates;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
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

    @Before(value = "methodAspect() && @annotation(logTrace)")
    public void doBefore(LogTrace logTrace) {
        addTraceId();
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
