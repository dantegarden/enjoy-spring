package com.enjoy.aop.proxy.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 被代理对象
 * @author: lij
 * @create: 2019-09-18 15:41
 */
@Slf4j
@AllArgsConstructor
public class Idol implements Star {

    private String name;

    @Override
    public boolean sing() {
        log.info(this.name + "唱歌");
        return true;
    }
}
