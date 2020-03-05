package curry.qin.SpringAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.SpringAop
 * @date 2020/3/5 9:14
 * @Copyright © 2019-2020 yamibuy
 */
@Aspect
@Order(3)
@Component
//顺序 先是环绕增强 -> 环绕调用proceed之后才去调用before增强 在调用after增强
public class TestAnnotationAspect {

    @Before("@annotation(test)")
    public void beforeTest(JoinPoint point, TestAnnotation test){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
    }

    @After("execution(public * curry.qin..*.*(..))")
    public void afterTest(JoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
    }

    /***
     * 环绕增强必须手动切调用切入点的方法
     * @param point
     * @param test
     */
    @Around("@annotation(test)")
    public void aroundTest(ProceedingJoinPoint point, TestAnnotation test) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        point.proceed();//执行目标方法 否则环绕不调用目标方法
    }
}
