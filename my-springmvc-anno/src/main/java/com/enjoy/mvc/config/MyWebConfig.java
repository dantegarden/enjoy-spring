package com.enjoy.mvc.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.enjoy.mvc.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.List;
import java.util.ServiceConfigurationError;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-23 20:51
 */

@EnableWebMvc
@Configuration
@ComponentScan(value = {"com.enjoy.mvc"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = {Controller.class, Configuration.class}),
}, useDefaultFilters = false)
public class MyWebConfig extends WebMvcConfigurationSupport {

    /**把根目录下的静态资源放开，
     * 不过访问静态资源时，请求路径前要加上“/static/”
     * **/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/");
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    /**给访问jsp的请求加上前缀（“/WEB-INF/pages/”） 和后缀 (".jsp")
     * **/
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }


    /**
     * fastjon配置
     * **/
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setDefaultCharset(Charset.forName("UTF-8"));

        FastJsonConfig config = new FastJsonConfig();
        config.setCharset(Charset.forName("UTF-8"));

        converter.setFastJsonConfig(config);
        converters.add(converter);
    }

    /**拦截器**/
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**"); //.excludePathPatterns();
    }

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}
