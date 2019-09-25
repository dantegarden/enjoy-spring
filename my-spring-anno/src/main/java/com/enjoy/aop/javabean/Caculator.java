package com.enjoy.aop.javabean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: 计算器
 * @author: lij
 * @create: 2019-09-17 15:44
 */
@Component
@Slf4j
public class Caculator {
    /**
     * 除法
     * @param a
     * @param b
     * @return: int
     */
    public int div(int a, int b){
        log.info("执行目标方法");
        return a / b ;
    }
}
