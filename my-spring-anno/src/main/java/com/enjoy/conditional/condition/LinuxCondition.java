package com.enjoy.conditional.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @description: 注入条件
 * @author: lij
 * @create: 2019-09-14 21:02
 */
public class LinuxCondition implements Condition {
    /**
     * @param context 当前上下文
     * @param metadata 当前扫描的bean的注解信息
     * @return: boolean
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //是否为windows系统
        //获取IOC容器正在使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取当前的环境变量
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        if(osName.contains("linux")){
            return true;
        }
        return false;
    }
}
