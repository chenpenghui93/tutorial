package com.example.javabasic.sample.annotation.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

/**
 * @Description
 * @Author chenpenghui
 * @Date 2020/4/19
 */
//@Component
@Order(2)
public class CommandLineRunnerTest1 implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(CommandLineRunnerTest1.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("执行CommandLineRunnerTest1...");
        for (int i = 0; i < args.length; i++) {
            log.info("args[{}]: {}", i, args[i]);
        }
    }
}
