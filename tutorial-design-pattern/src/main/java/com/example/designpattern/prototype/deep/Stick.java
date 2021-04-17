package com.example.designpattern.prototype.deep;

import java.io.Serializable;

/**
 * @Author cph
 * @Date 2019/12/28
 */
public class Stick implements Serializable {
    public float h = 100;
    public float d = 10;

    public void big() {
        this.h *= 2;
        this.d *= 2;
    }

    public void small() {
        this.h /= 2;
        this.d /= 2;
    }
}
