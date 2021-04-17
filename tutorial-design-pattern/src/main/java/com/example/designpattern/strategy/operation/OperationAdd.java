package com.example.designpattern.strategy.operation;

/**
 * @Description
 * @Author cph
 * @Date 2020/3/28
 */
public class OperationAdd implements Stragegy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
