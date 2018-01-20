package com.ybz.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/1/6.
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelAnno {
    String head() default "";
}
