package com.example.designpattern.decorator.v2;

/**
 * @Author cph
 * @Date 2020/2/9
 */
public class SausageDecorator extends BattercakeDecorator {

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+1个香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
