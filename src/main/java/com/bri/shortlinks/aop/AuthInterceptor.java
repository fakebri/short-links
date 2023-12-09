package com.bri.shortlinks.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 在请求处理之前执行，可以进行身份验证、日志记录等操作
        if (request.getSession().getAttribute("userName") == null) {
            response.sendRedirect("/auth/status");
            return false;
        }
        return true; // 如果返回 true，继续执行后续的拦截器和处理器；如果返回 false，终止请求处理链
    }

}