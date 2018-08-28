package com.blue.thrift.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {

    /**
     * 是否打印耗时
     */
    boolean durationPrint() default false;

    /**
     * 是否打印结果
     */
    boolean resultPrint() default true;
}
