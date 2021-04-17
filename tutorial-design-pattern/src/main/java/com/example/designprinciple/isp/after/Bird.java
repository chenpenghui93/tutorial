package com.example.designprinciple.isp.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Bird implements IEatAnimal, IFlyAnimal {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }

    //仅实现需要的接口即可
}
