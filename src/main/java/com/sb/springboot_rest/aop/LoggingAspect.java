package com.sb.springboot_rest.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER =  LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.sb.springboot_rest.service.JobService.getJob(..))")
    public void LogMethodBefore(JoinPoint jp){
        LOGGER.info("Method called before " + jp.getSignature().getName());
    }
    @After("execution(* com.sb.springboot_rest.service.JobService.getJob(..))")
    public void LogMethodAfter(JoinPoint jp){
        LOGGER.info("Method called after finally " + jp.getSignature().getName());
    }
    @AfterReturning("execution(* com.sb.springboot_rest.service.JobService.getJob(..))")
    public void LogMethodAfterExecution(JoinPoint jp){
        LOGGER.info("Method called after successful execution " + jp.getSignature().getName());
    }

}
