package com.dg.servlet.resolver.impl;

import com.dg.annotation.DgComponent;
import com.dg.annotation.DgRequestParam;
import com.dg.servlet.resolver.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-25 15:35
 */
@DgComponent("dgRequestParamArgResolver")
public class DgRequestParamArgResolver implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int index, Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations(); //几个参数
        Annotation[] paramAnnos = parameterAnnotations[index]; //每个参数有多个注解
        for (int i = 0; i < paramAnnos.length; i++) {
            //有资格被解析
            if(DgRequestParam.class.isAssignableFrom(paramAnnos[i].getClass())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object resolve(HttpServletRequest request, HttpServletResponse response, Class<?> type, int index, Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Annotation[] paramAnnos = parameterAnnotations[index];
        for (int i = 0; i < paramAnnos.length; i++) {
            //有资格被解析
            if(DgRequestParam.class.isAssignableFrom(paramAnnos[i].getClass())){
                DgRequestParam dgRequestParam = (DgRequestParam) paramAnnos[i];
                String paramName = dgRequestParam.value();
                return request.getParameter(paramName);
            }
        }
        return false;
    }
}
