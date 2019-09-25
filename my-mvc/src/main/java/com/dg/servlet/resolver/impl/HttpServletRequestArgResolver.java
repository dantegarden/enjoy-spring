package com.dg.servlet.resolver.impl;

import com.dg.annotation.DgComponent;
import com.dg.servlet.resolver.ArgumentResolver;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-25 15:31
 */
@DgComponent("httpServletRequestArgResolver")
public class HttpServletRequestArgResolver implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int index, Method method) {
        // type 是不是 ServletRequest的子类
        return ServletRequest.class.isAssignableFrom(type);
    }

    @Override
    public Object resolve(HttpServletRequest request, HttpServletResponse response, Class<?> type, int index, Method method) {
        return request;
    }
}
