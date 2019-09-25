package com.enjoy.scope.config;

import com.enjoy.bean.javabean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @description: 配置类
 * @author: lij
 * @create: 2019-09-14 17:10
 */
@Configuration
public class MainConfig3 {

    //默认是单实例的
    @Bean
    public Person person(){
        return new Person();
    }


    /**
     * singleton：单实例（默认） IOC启动时就会调用方法创建对象，并放到IOC容器中。以后每次直接从IOC拿
     * prototype：多实例 IOC容器启动时，IOC容器启动并不会去调用方法创建对象，而是每次获取时才会创建
     * request：主要针对web应用，递交一次请求创建一个实例
     * session：为每个session创建一个实例
     * **/
    @Bean
    @Scope("prototype")
    public Person personm(){
        return new Person();
    }
}
