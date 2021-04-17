package com.example.designprinciple.isp.before;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Dog implements IAnimal {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {
        //这个接口只能空着，接口设计不合适
    }

    @Override
    public void swim() {

    }
}
