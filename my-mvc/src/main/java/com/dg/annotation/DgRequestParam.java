package com.dg.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER) //标在参数上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DgRequestParam {
    String value() default "";
}
