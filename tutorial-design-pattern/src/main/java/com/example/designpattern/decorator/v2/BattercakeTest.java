package com.example.designpattern.decorator.v2;

/**
 * @Author cph
 * @Date 2020/2/9
 */
public class BattercakeTest {
    public static void main(String[] args) {
        Battercake battercake;

        battercake = new BaseBattercake();
        battercake = new EggDecorator(battercake);
        battercake = new EggDecorator(battercake);
        battercake = new SausageDecorator(battercake);

        System.out.println(battercake.getMsg() + ", 总价：" + battercake.getPrice());
    }
}
