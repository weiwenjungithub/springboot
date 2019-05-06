package com.wwj.spirngboot.limiter.aop;

import com.google.common.util.concurrent.RateLimiter;
import com.wwj.spirngboot.limiter.annotation.ServiceLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author weiwenjun
 * @since 2019/5/6
 */
@Aspect
@Component
public class LimiterAspect {
    RateLimiter rateLimiter = RateLimiter.create(0.5, 1, TimeUnit.SECONDS);

    @Around(value = "@annotation(serviceLimiter)")
    public Object execute(ProceedingJoinPoint joinPoint, ServiceLimiter serviceLimiter) {
        Object proceed = null;
        if (rateLimiter.tryAcquire()) {
            try {
                proceed = joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else {
            return "请求繁忙";
        }
        return proceed;
    }

}
