package com.zdz.test.web.tool.filter;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-20
 */
public class TraceIdUtil {

    private static final InheritableThreadLocal<String> traceLocal = new InheritableThreadLocal();

    public static String getTraceId() {
        return traceLocal.get();
    }

    public static void setTraceId(String traceId) {
        traceLocal.set(traceId);
    }

    public static void removeTraceId() {
        traceLocal.remove();
    }
}
