package com.enjoy.extend.javabean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 月亮
 * @author: lij
 * @create: 2019-09-21 15:35
 */
@Data
@Slf4j
public class Moon {
    public Moon() {
      log.info("Moon constructor run");
    }
}
