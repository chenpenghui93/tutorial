package com.example.designpattern.singleton.register;

/**
 * @author cph
 * @date 2019/4/6
 */
public enum EnumSingleton {

    INSTANCE;

    private Object object;

    public static final EnumSingleton getInstance() {
        return INSTANCE;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
