package com.wwj.spirngboot.limiter.annotation;

import java.lang.annotation.*;

/**
 * 限流注解
 * @author weiwenjun
 * @since 2019/5/6
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceLimiter {

}
