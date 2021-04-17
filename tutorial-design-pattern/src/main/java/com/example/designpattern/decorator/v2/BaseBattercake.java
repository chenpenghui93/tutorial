package com.example.designpattern.decorator.v2;

/**
 * @Author cph
 * @Date 2020/2/9
 */
public class BaseBattercake extends Battercake {
    @Override
    public String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
