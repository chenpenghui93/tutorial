package com.example.designpattern.strategy.operation;

/**
 * @Description
 * @Author cph
 * @Date 2020/3/28
 */
public class Context {

    private Stragegy stragegy;

    public Context(Stragegy stragegy) {
        this.stragegy = stragegy;
    }

    public int executeStrategy(int num1, int num2) {
        return stragegy.doOperation(num1, num2);
    }
}
