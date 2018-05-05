package com.lz.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者      : 刘朝
 * 创建日期  : 2018/5/5 下午2:12
 * 描述     : 注解,
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RouterParam {

    String value() default "";
}
