package com.example.javabasic.sample.easyrule.fizz;

import org.jeasy.rules.annotation.*;

/**
 * @Description
 * @Author chenpenghui
 * @Date 2020/4/17
 */
@Rule(name = "被8整除", description = "number如果被8整除，打印： number is divided by eight.")
public class EightRule {
    @Condition
    public boolean isEight(@Fact("number") int number) {
        return number % 8 == 0;
    }

    @Action
    public void eightAction(@Fact("number") int number) {
        System.out.println(number + "is divided by eight.");
    }

    @Priority
    public int getPriority() {
        return 8;
    }
}
