package com.example.javabasic.sample.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 异步调用实现步骤：
 * 1、pom.xml添加依赖 spring-boot-starter-web
 * 2、启动类添加注解 @EnableAsync
 * 3、方法上添加注解 @Async
 * 4、类间方法直接调用
 * 5、获取异步执行结果使用Future
 * <p>
 * 可能遇到的问题：
 * 1、异步方法使用static修饰导致@Async失效
 * 2、异步类没有使用@Compoment（或其它注解）导致Spring无法扫描到异步类
 * 3、异步方法调用方与被调用方不能在同一个类中
 * 4、类中需要使用@Autowired、@Resource等自动注入，不能手动new对象
 * 5、如果使用Spring Boot框架，必须在启动类中添加@EnableSync注解
 * <p>
 * 参考 https://juejin.cn/post/6844903904539312141
 *
 * @author chenpenghui
 * @date 2020-11-27
 */
@RestController
@Slf4j
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/task")
    public String taskExecute() {
        try {
            Future<String> r1 = taskService.doTaskOne();
            Future<String> r2 = taskService.doTaskTwo();
            Future<String> r3 = taskService.doTaskThree();

            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            log.info("当前线程为 {}, 请求方法为 {}, 请求路径为 {}", Thread.currentThread().getName(), request.getMethod(), request.getRequestURL().toString());

            while (true) {
                if (r1.isDone() && r2.isDone() && r3.isDone()) {
                    log.info("execute all tasks");
                    break;
                }
                Thread.sleep(200);
            }
            log.info("\n" + r1.get() + "\n" + r2.get() + "\n" + r3.get());
        } catch (Exception e) {
            log.error("error executing task for {}", e.getMessage());
        }
        return "ok";
    }

    @GetMapping("/taskTest")
    public String task1Execute(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(()->{
            System.out.println("异步线程开启...");
            RequestContextHolder.setRequestAttributes(requestAttributes);
            System.out.println("异步线程结束...");
        });

        return "ok";
    }


}
