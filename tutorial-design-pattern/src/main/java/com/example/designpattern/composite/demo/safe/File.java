package com.example.designpattern.composite.demo.safe;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public class File extends Directory {

    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
