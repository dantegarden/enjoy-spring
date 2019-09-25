package com.dg.servlet.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-25 15:12
 */
public interface ServletHandler {
    Object[] handle(HttpServletRequest request, HttpServletResponse response, Method method, Map<String,Object> beans);
}
