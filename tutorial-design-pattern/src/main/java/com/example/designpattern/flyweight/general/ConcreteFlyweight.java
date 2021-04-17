package com.example.designpattern.flyweight.general;

/**
 * 具体享元角色
 *
 * @author chenpenghui
 * @date 2021-3-27
 */
public class ConcreteFlyweight implements IFlyweight {

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Object address: " + System.identityHashCode(this));
        System.out.println("intrinsicState: " + this.intrinsicState);
        System.out.println("extrinsicState: " + extrinsicState);
    }
}
