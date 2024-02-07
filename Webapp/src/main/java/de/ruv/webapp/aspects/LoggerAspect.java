package de.ruv.webapp.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Before("execution(public * de.ruv.webapp.presentation.controller.PersonenController.*(..))")
    public void logAdvice(JoinPoint joinPoint) {
        log.warn("####### Log advice #######");
        log.warn(joinPoint.getSignature().getName() + " wurde gerufen");
    }

    @AfterReturning(value = "execution(public * de.ruv.webapp.presentation.controller.PersonenController.*(..))",  returning = "result")
    public void afterdemo(JoinPoint joinPoint, Object result) {
        log.warn("####### Log advice #######");
        log.warn(joinPoint.getSignature().getName() + " wurde gerufen");
        log.warn(result.toString());
    }

    @AfterThrowing(value = "execution(public * de.ruv.webapp.presentation.controller.PersonenController.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.warn("####### Log advice #######");
        log.warn(joinPoint.getSignature().getName() + " Kein Upps: " + ex);
    }

    @After("execution(public * de.ruv.webapp.presentation.controller.PersonenController.*(..))")
    public void after(JoinPoint joinPoint) {
        log.warn("####### Log advice #######");
        log.warn(joinPoint.getSignature().getName() + " wurde gerufen");
    }

    @Around("execution(public * de.ruv.webapp.presentation.controller.PersonenController.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // prüfen
        return proceedingJoinPoint.proceed();
    }
}
