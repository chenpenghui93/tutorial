package com.example.javabasic.sample.middleware.easyrule.helloworld;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

/**
 * @author chenpenghui
 * @date 2020/6/15
 */
@Rule(name = "Hello World rule", description = "say hello world")
public class HelloWorldRule {

    @Condition
    public boolean when() {
        return true;
    }

    @Action
    public void then() throws Exception {
        System.out.println("hello world");
    }

}
