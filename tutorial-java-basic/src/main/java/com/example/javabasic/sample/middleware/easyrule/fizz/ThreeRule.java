package com.example.javabasic.sample.middleware.easyrule.fizz;

import org.jeasy.rules.annotation.*;

/**
 * @Description
 * @Author chenpenghui
 * @Date 2020/4/17
 */
@Rule(name = "被3整除", description = "number如果被3整除，打印： number is divided by three.")
public class ThreeRule {

    @Condition
    public boolean isThree(@Fact("number") int number) {
        return number % 3 == 0;
    }

    @Action
    public void threeAction(@Fact("number") int number) {
        System.out.println(number + "is divided by three.");
    }

    @Priority
    public int getPriority() {
        return 1;
    }
}
