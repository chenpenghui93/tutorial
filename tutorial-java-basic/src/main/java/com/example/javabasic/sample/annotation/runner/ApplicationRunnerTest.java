package com.example.javabasic.sample.annotation.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @Description
 * @Author chenpenghui
 * @Date 2020/4/19
 */
//@Component
public class ApplicationRunnerTest implements ApplicationRunner {

    private static Logger log = LoggerFactory.getLogger(ApplicationRunnerTest.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("执行ApplicationRunner...");
        log.info("获取参数：" + args.getOptionValues("param"));
    }
}
