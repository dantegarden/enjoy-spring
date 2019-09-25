package com.enjoy.aop.proxy.cglib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-18 16:36
 */
@Slf4j
@Data
public class Idol {
    private String name;
    
    public void sing(){
        log.info(this.name + "唱歌");
    }
}
