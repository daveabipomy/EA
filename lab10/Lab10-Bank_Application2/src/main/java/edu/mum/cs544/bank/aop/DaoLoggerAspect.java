package edu.mum.cs544.bank.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoLoggerAspect {

    @Autowired
    private ILogger logger;



    @After("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void log(JoinPoint joinpoint) {
        logger.log("Called method:" + joinpoint.getSignature().getName()
                + " on " + joinpoint.getTarget().getClass());
    }
}
