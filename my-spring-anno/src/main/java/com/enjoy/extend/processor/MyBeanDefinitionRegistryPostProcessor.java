package com.enjoy.extend.processor;

import com.enjoy.extend.javabean.Moon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-21 16:07
 */
@Component
@Slf4j
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     *
     * */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("postProcessBeanDefinitionRegistry");
        log.info("bean的数量：{}", registry.getBeanDefinitionCount());

        RootBeanDefinition moon2 = new RootBeanDefinition(Moon.class);
        registry.registerBeanDefinition("moon2", moon2);

        AbstractBeanDefinition moon3 = BeanDefinitionBuilder.rootBeanDefinition(Moon.class).getBeanDefinition();
        registry.registerBeanDefinition("moon3", moon3);
    }

    /**
     * BeanDefinitionRegistryPostProcessor继承了BeanFactoryPostProcessor，所以也有这个方法
     * */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("postProcessBeanFactory run");
        log.info("bean的数量：{}", beanFactory.getBeanDefinitionCount());
    }
}
