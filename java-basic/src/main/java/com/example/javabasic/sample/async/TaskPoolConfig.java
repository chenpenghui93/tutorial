package com.example.javabasic.sample.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 配置线程池
 *
 * @author chenpenghui
 * @date 2020-11-27
 */
@Configuration
public class TaskPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数（默认线程数）
        executor.setCorePoolSize(5);
        // 最大线程数
        executor.setMaxPoolSize(10);
        // 缓冲队列数
        executor.setQueueCapacity(100);
        // 允许线程空闲时间
        executor.setKeepAliveSeconds(60);
        // 线程池名称前缀
        executor.setThreadNamePrefix("taskExecutor-");
        // 线程池关闭前等待任务完成
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 线程池中任务等待时间，超时则强制销毁
        executor.setAwaitTerminationSeconds(600);
        // 传递线程上下文
        executor.setTaskDecorator(new ContextDecorator());
        // 线程池对拒绝任务的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
