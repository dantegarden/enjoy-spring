package com.enjoy.lifecycle.config;

import com.enjoy.lifecycle.javabean.Order;
import com.enjoy.lifecycle.processor.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @description: 生命周期配置类
 * @author: lij
 * @create: 2019-09-15 14:44
 */
@Configuration
public class MainConfig7 {

    @Bean(initMethod = "initMethod", destroyMethod = "destoryMethod")
    public Order order(){
        return new Order();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
