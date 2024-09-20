package tibo.spring.exopoa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("@annotation(tibo.spring.exopoa.annotation.Logging)")
    public void logging() {
    }

    @Around("logging()")
    public void loggingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();

        System.out.printf("""
                        Beginning %s
                        Arguments: %s
                        Return value: %s
                        Ending %s
                        """,
                methodName,
                Arrays.toString(proceedingJoinPoint.getArgs()),
                proceedingJoinPoint.proceed(),
                methodName);
    }
}
