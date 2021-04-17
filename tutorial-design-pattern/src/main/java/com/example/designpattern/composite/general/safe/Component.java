package com.example.designpattern.composite.general.safe;

/**
 * 抽象根节点
 *
 * @author chenpenghui
 * @date 2021-3-28
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String operation();

}
