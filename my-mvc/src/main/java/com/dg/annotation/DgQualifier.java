package com.dg.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD}) //标在字段上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DgQualifier {
    String value() default "";
}
