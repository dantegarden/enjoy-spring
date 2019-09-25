package com.enjoy.lifecycle.javabean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @description: 火车
 * @author: lij
 * @create: 2019-09-15 15:30
 */
@Component
@Slf4j
public class Train implements EnvironmentAware {

    @Autowired
    private Order order;

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println(order.getOrderNum());
        this.env = environment;
    }
}
