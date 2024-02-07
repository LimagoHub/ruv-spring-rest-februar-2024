package de.ruv.webapp.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
@Slf4j
public class LoggerAspect {



    //@Before("PointCuts.personenControllerMethods()")
    @Before("PointCuts.benchmarkMethods()")
    public void logAdvice(JoinPoint joinPoint) {
        log.warn("####### Log advice #######");
        log.warn(joinPoint.getSignature().getName() + " wurde gerufen");
    }

    @AfterReturning(value = "PointCuts.personenControllerMethods()",  returning = "result")
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

    @Around("PointCuts.benchmarkMethods()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var start = Instant.now();
        var retval = proceedingJoinPoint.proceed();
        var ende = Instant.now();
        var duration = Duration.between(start, ende);
        System.out.println("Duration of " + proceedingJoinPoint.getSignature().getName() + " was " +duration.toMillis()+"ms");
        return retval;
    }
}
