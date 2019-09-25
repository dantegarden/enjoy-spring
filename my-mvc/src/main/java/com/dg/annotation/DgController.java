package com.dg.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})  //标在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DgController {
    String value() default "";
}
