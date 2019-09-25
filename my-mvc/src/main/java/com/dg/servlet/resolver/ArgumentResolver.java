package com.dg.servlet.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-25 15:28
 */
public interface ArgumentResolver {
    /**判断是否需要解析*/
    boolean support(Class<?> type, int index, Method method);
    /**参数解析*/
    Object resolve(HttpServletRequest request, HttpServletResponse response,
            Class<?> type, int index, Method method);
}
