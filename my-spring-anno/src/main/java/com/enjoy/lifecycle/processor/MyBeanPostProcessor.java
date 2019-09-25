package com.enjoy.lifecycle.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @description: 后置处理器
 * @author: lij
 * @create: 2019-09-15 16:21
 */
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("MyBeanPostProcessor postProcessBeforeInitialization: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("MyBeanPostProcessor postProcessAfterInitialization: " + beanName);
        return bean;
    }
}
