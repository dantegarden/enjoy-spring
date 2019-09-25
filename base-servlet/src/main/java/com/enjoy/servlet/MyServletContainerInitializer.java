package com.enjoy.servlet;

import com.enjoy.servlet.filter.MyFilter;
import com.enjoy.servlet.listener.MyListener;
import com.enjoy.servlet.servlet.MyServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-23 16:17
 */
@HandlesTypes(value={MyService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     *  
     * Set<Class<?>> set：感兴趣的类型的所有子类型；
     * ServletContext servletContext:代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
     * @return: void
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类型及子类");
        set.forEach(System.out::println);
        //实例化监听器
        servletContext.addListener(MyListener.class);
        //实例化Servlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("myServlet", new MyServlet());
        servlet.addMapping("/myTest");
        //实例化Filter
        FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
