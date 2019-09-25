package com.enjoy.aop.javabean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-19 17:38
 */
@Component
@Slf4j
public class MyBook {
    public void write(){
        log.info("you write something on book");
    }
}
