package com.enjoy.mvc.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-24 17:23
 */
@Slf4j
public class MyInterceptor extends HandlerInterceptorAdapter {
    // 请求处理之前。如果返回true则放行，如果返回false，中断请求流程，不会被其他controller或拦截器拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("------preHandle------ {}", request.getRequestURI());
        return true;
    }

    //请求处理完毕，视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("------postHandle------ {}", request.getRequestURI());
    }
    //视图渲染完毕时调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("------afterCompletion------");
    }
}
