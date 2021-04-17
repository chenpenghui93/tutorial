package com.example.designpattern.composite.demo.safe;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public abstract class Directory {

    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();
}
