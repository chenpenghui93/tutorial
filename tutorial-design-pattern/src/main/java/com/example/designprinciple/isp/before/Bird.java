package com.example.designprinciple.isp.before;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Bird implements IAnimal {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {
        //这个接口只能空着，接口设计不合适
    }
}
