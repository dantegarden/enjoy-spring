package com.enjoy.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description: 配置类
 * @author: lij
 * @create: 2019-09-17 15:41
 */
@Configuration
@ComponentScan("com.enjoy.aop")
@EnableAspectJAutoProxy  //启用动态代理
public class MainConfig10 {

}
