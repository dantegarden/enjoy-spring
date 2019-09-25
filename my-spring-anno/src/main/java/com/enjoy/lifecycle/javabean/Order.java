package com.enjoy.lifecycle.javabean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description: 订单
 * @author: lij
 * @create: 2019-09-15 14:47
 */
@Slf4j
@Data
public class Order implements InitializingBean, DisposableBean, BeanFactoryAware, EmbeddedValueResolverAware, BeanNameAware, ApplicationContextAware {
    private Integer orderNum;

    private ApplicationContext context;
    private String beanName;
    private BeanFactory beanFactory;

    public Order() {
        log.info("Order constructor run ...........");
    }

    public void initMethod(){
        log.info("Order initMethod .........");
    }

    public void destoryMethod(){
        log.info("Order destoryMethod .........");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Order InitializingBean.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Order DisposableBean.destroy");
    }

    @PostConstruct
    public void initConstruct(){
        log.info("Order PostConstruct");
    }

    @PreDestroy
    public void preDestory(){
        log.info("Order PreDestroy");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        log.info("Order BeanFactoryAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        log.info("Order ApplicationContextAware");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        log.info("Order BeanNameAware");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        log.info("Order EmbeddedValueResolverAware : SpringEL{}", resolver.resolveStringValue("#{3*8}"));
    }
}
