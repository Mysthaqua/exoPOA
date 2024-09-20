package tibo.spring.exopoa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
    @Pointcut("@annotation(tibo.spring.exopoa.annotation.Performance)")
    public void performance() {
    }

    @Around("performance()")
    public long performanceAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.printf("The method took %s ms to process.\n", duration);
        return duration;
    }
}
