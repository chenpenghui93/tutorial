package com.example.javabasic.sample.aop.aspect;

import com.example.javabasic.sample.aop.annotation.MyLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志切面
 *
 * @author chenpenghui
 * @date 2020-9-26
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 定义切入点：对要拦截的方法进行定义与限制，如指定包、指定类、指定方法
     * <p>
     * 1、任意的公共方法
     * execution(public * *(..))
     * <p>
     * 2、以set开头的所有的方法
     * execution(* set*(..))
     * <p>
     * 3、com.example.javabasic.sample.aop.biz.testController这个类里的所有的方法
     * execution(* com.example.javabasic.sample.aop.biz.testController.* (..))
     * <p>
     * 4、com.example.javabasic.sample.aop.biz包下的所有的类的所有的方法
     * execution(* com.example.javabasic.sample.aop.biz.*.*(..))
     * <p>
     * 5、com.example.javabasic.sample.aop.biz包及子包下所有的类的所有的方法
     * execution(* com.example.javabasic.sample.aop.biz..*.*(..))
     * <p>
     * 6、com.example.javabasic.sample.aop.biz包及子包下所有的类的有三个参数，
     * 第一个参数为String类型，第二个参数为任意类型，第三个参数为Long类型的方法
     * <p>
     * @Pointcut("execution(* com.example.javabasic.sample.aop.biz..*.*(String,*,Long))")
     * <p>
     * 7、任何标注了MyLog注解的目标类方法
     * @Pointcut("@annotation(com.example.javabasic.sample.aop.annotation.MyLog)")
     */
    @Pointcut("@annotation(com.example.javabasic.sample.aop.annotation.MyLog)")
    public void pointCut() {
    }

    /**
     * 前置通知，在目标方法调用前执行
     */
    @Before("pointCut()")
    public void before() {
        System.out.println("前置通知，在目标方法调用前执行... @Before(\"cutMethod()\")");
    }

    /**
     * 后置通知，在目标方法执行后调用，若目标方法执行过程中抛出异常则不执行
     */
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("后置通知，在目标方法执行后调用，若目标方法执行过程中抛出异常则不执行... @AfterReturning(\"cutMethod()\")");
    }

    /**
     * 后置通知，在目标方法执行后调用，无论目标方法执行过程中是否抛出异常都会调用
     */
    @After("pointCut()")
    public void after() {
        System.out.println("后置通知，在目标方法执行后调用，无论目标方法执行过程中是否抛出异常都会调用... @After(\"cutMethod()\")");
    }

    /**
     * 异常通知，在目标方法执行过程中抛出异常时执行
     */
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("异常通知，在目标方法执行过程中抛出异常时执行... @AfterThrowing(\"cutMethod()\")");
    }

    /**
     * 环绕通知，在目标方法执行过程中自行选择切入
     */
    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知，在目标方法执行过程中自行选择切入... @Around(\"cutMethod()\")");
        // 目标方法的名称
        String methodName = joinPoint.getSignature().getName();
        // 目标方法的参数
        Object[] params = joinPoint.getArgs();
        MyLog myLog = getDeclaredAnnotation(joinPoint);
        // 执行源方法
        System.out.println("before joinPoint.proceed()...");
        joinPoint.proceed();
        System.out.println("after joinPoint.proceed()...");
        System.out.println("methodName: " + methodName + ", params: " + params.toString());
        System.out.println("myLog.value(): " + myLog.value());
    }

    /**
     * 获取方法中声明的注解
     *
     * @param joinPoint
     * @return
     */
    private MyLog getDeclaredAnnotation(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        // 获取方法对应的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        // 根据类、方法、参数类型获取到方法的具体信息
        Method method = targetClass.getMethod(methodName, parameterTypes);
        // 获取方法定义的注解信息
        return method.getDeclaredAnnotation(MyLog.class);
    }

}
