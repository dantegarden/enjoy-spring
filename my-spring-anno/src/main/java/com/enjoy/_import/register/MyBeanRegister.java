package com.enjoy._import.register;

import com.enjoy._import.javabean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description: bean注册器
 * @author: lij
 * @create: 2019-09-14 21:41
 */
public class MyBeanRegister implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata 当前扫描到的bean的注解
     * @param registry 注册器
     *                 把所有需要添加到ioc容器中的bean加入
     * @return: void
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //可以在这里加注册条件，比如：容器中同时存在Dog和Cat时，才注册Pig
        boolean hasCat = registry.containsBeanDefinition("com.enjoy._import.javabean.Cat");
        boolean hasDog = registry.containsBeanDefinition("com.enjoy._import.javabean.Dog");
        if(hasCat && hasDog){
            //要注册bean，需要先封装
            RootBeanDefinition pigBeanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig", pigBeanDefinition);
        }
    }
}
