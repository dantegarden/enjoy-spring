package com.enjoy.extend.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @description: BeanFactory后置处理器
 * @author: lij
 * @create: 2019-09-21 15:39
 */
@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**只针对BeanFactory的bean做后置处理*/
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("postProcessBeanFactory run");
        //所有bean的定义，已经加载到beanFactory，此时还没创建，只有定义。
        int count = beanFactory.getBeanDefinitionCount();
        log.info("beanFactory中有{}个bean", count);
        if(count>0){
            for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
                log.info(beanDefinitionName);
            }
        }
    }
}
