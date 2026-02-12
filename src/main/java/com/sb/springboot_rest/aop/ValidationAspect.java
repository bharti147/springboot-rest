package com.sb.springboot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.sb.springboot_rest.service.JobService.getJob(..)) && args(postId)")
    public Object PerformanceMonitor(ProceedingJoinPoint jp, int postId) throws Throwable {

        if(postId < 0){
            LOGGER.info("postId is negative, updating it" + jp.getSignature().getName());
            postId = -postId;
            LOGGER.info("postId is updated" + jp.getSignature().getName());
        }
        Object obj  =  jp.proceed(new Object[]{postId});
        return obj;
    }

}
