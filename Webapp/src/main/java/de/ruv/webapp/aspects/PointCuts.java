package de.ruv.webapp.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(public * de.ruv.webapp.presentation.controller.PersonenController.*(..))")
    public void personenControllerMethods(){}

    @Pointcut("@within(de.ruv.webapp.aspects.Benchmark)")
    public void benchmarkMethods(){}
}
