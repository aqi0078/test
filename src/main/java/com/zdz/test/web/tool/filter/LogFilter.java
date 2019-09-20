package com.zdz.test.web.tool.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.apache.commons.io.IOUtils;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-20
 */
@Slf4j
public class LogFilter  implements Filter {

    private static final Set<String> EXCLUDE_PATH =
            Sets.newHashSet("/hello", "/test");

    private static final Set<String> unprintableParams =
            Sets.newHashSet("password", "payPwd", "session_value");

    private static final int MAX_RESPONSE_LENGTH = 1000;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        boolean isError = false;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath();
    log.info("###path==={}",path);
        for (String p : EXCLUDE_PATH) {
            if (path.startsWith(p)) {
                filterChain.doFilter(request, servletResponse);
                return;
            }
        }

        // 包装 request、response
        MyHttpServletRequestWrapper myServletRequest = new MyHttpServletRequestWrapper(request);
        MyHttpServletResponseWrapper myServletResponse = new MyHttpServletResponseWrapper(response);

        String requestUrl = request.getRequestURL().toString();
        String params = getQuery(request);

        try {
            filterChain.doFilter(myServletRequest, myServletResponse);
            myServletResponse.flushBuffer();
        } catch (Exception e) {
            isError = true;
        } finally {
            //异步处理类DeferredResult 会造成finally块的代码执行两次
            String responseBody = myServletResponse.getBody();
            responseBody =
                    responseBody.substring(0, Math.min(responseBody.length(), MAX_RESPONSE_LENGTH));
            if (StringUtils.isEmpty(responseBody)) {
                //DeferredResult的情况，先把traceId存入request，再给到MDC
                if (StringUtils.isNotBlank(MDC.get(LogConstant.X_B3_SpanId))) {
                    request.setAttribute(LogConstant.X_B3_TraceId, MDC.get(LogConstant.X_B3_TraceId));
                    request.setAttribute(LogConstant.X_B3_SpanId, MDC.get(LogConstant.X_B3_SpanId));
                    request.setAttribute(LogConstant.X_Span_Export, MDC.get(LogConstant.X_Span_Export));
                }
                return;
            }
            if (request.getAttribute(LogConstant.X_B3_SpanId) != null) {
                MDC.put(LogConstant.X_B3_TraceId,
                        request.getAttribute(LogConstant.X_B3_TraceId).toString());
                MDC.put(LogConstant.X_B3_SpanId, request.getAttribute(LogConstant.X_B3_SpanId).toString());
                MDC.put(LogConstant.X_Span_Export,
                        request.getAttribute(LogConstant.X_Span_Export).toString());
            }
            if ("GET".equalsIgnoreCase(request.getMethod()) || "DELETE".equalsIgnoreCase(
                    request.getMethod())) {
                log.info("耗时:{}毫秒, IP:{}, url:{}, method:{}, params:{}, Exception:{}, 返回值:{}",
                        System.currentTimeMillis() - begin, getIp(request), requestUrl, request.getMethod(),
                        params, isError, responseBody);
            } else {
                log.info(
                        "耗时:{}毫秒, IP:{}, url:{}, method:{}, contentType:{}, params:{}, Exception:{}, 返回值:{}",
                        System.currentTimeMillis() - begin, getIp(request), requestUrl, request.getMethod(),
                        request.getContentType(), params, isError, responseBody);
            }
            //移除操作是线程安全的
            MDC.remove(LogConstant.X_B3_TraceId);
            MDC.remove(LogConstant.X_B3_SpanId);
            MDC.remove(LogConstant.X_Span_Export);
            request.removeAttribute(LogConstant.X_B3_TraceId);
            request.removeAttribute(LogConstant.X_B3_SpanId);
            request.removeAttribute(LogConstant.X_Span_Export);
        }

    }

    private static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-real-ip");

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        //过滤反向代理的ip
        String[] stemps = ip.split(",");
        if (stemps.length >= 1) {
            //得到第一个IP，即客户端真实IP
            ip = stemps[0];
        }

        ip = ip.trim();
        if (ip.length() > 23) {
            ip = ip.substring(0, 23);
        }

        return ip;
    }

    /**
     * 获取 request 中的 body 参数 格式为 [key=value][password=******]
     */
    private String getQuery(HttpServletRequest request) {
        if (isPostPutRequest(request)) {
            return getParameters(request) + getRequestBody(request);
        } else {
            return getParameters(request);
        }
    }


    private String getRequestBody(HttpServletRequest request) {
        try {
            return IOUtils.toString(request.getInputStream(), Charset.defaultCharset());
        } catch (IOException e) {
            return "";
        }
    }

    private boolean isPostPutRequest(HttpServletRequest request) {
        return "POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(
                request.getMethod());
    }

    private String getParameters(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Map<String, String[]> params = request.getParameterMap();
        for (String key : params.keySet()) {
            if (StringUtils.isBlank(key)) {
                continue;
            }
            if (unprintableParams.contains(key)) {
                sb.append('[').append(key).append("=***] ");
                continue;
            }
            sb.append('[').append(key).append('=').append(request.getParameter(key)).append("] ");
        }

        return sb.toString();
    }
}
