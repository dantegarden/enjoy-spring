package com.dg.servlet.handler;

import com.dg.annotation.DgComponent;
import com.dg.servlet.resolver.ArgumentResolver;
import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-25 15:16
 */
@DgComponent("servletHandlerAdapter")
public class ServletHandlerAdapter implements ServletHandler {
    @Override
    public Object[] handle(HttpServletRequest request, HttpServletResponse response,
                         Method method, Map<String, Object> beans) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] args = new Object[parameterTypes.length];
        //拿到所有argumentResolver
        Map<String,Object> resolvers = getTypedInstances(beans, ArgumentResolver.class);

        int index = 0;
        for (Class<?> parameterType : parameterTypes) {
            //找到参数类型对应的那个解析类
            for (Map.Entry<String, Object> resolverEntry : resolvers.entrySet()) {
                ArgumentResolver resolver = (ArgumentResolver) resolverEntry.getValue();
                if(resolver.support(parameterType, index, method)){
                    //解析
                    args[index] = resolver.resolve(request, response, parameterType, index, method);
                    break;
                }
            }
            index++;
        }
        return args;
    }

    /**从容器中找到某种类型的子类或实现类*/
    private Map<String, Object> getTypedInstances(Map<String, Object> beans, Class<?> type) {
        HashMap<String, Object> instanceMap = Maps.newHashMap();
        for (Map.Entry<String, Object> beanEntry : beans.entrySet()) {
            Object instance = beanEntry.getValue();
            Class<?>[] interfaces = instance.getClass().getInterfaces();
            if(interfaces!=null && interfaces.length > 0){
                for (Class<?> inf : interfaces) {
                    if (inf.isAssignableFrom(type)) {
                        instanceMap.put(beanEntry.getKey(), instance);
                    }
                }
            }
        }
        return instanceMap;
    }
}
