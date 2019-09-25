package com.enjoy.servlet.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-23 17:43
 */
@Slf4j
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("MyListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("MyListener contextDestroyed");
    }
}
