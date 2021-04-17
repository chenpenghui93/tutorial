package com.example.designpattern.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * @Author cph
 * @Date 2019/12/28
 */
public class MonkeyKing extends Monkey implements Cloneable, Serializable {
    public Stick stick;

    public MonkeyKing() {
        this.birthday = new Date();
        this.stick = new Stick();
    }

    @Override
    protected Object clone() {
        return this.deepClone();
    }

    public Object deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            MonkeyKing copy = (MonkeyKing) ois.readObject();
            copy.birthday = new Date();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public MonkeyKing shallowClone(MonkeyKing target) {
        MonkeyKing monkeyKing = new MonkeyKing();
        monkeyKing.height = target.height;
        monkeyKing.weight = target.weight;
        monkeyKing.stick = target.stick;
        monkeyKing.birthday = new Date();
        return monkeyKing;
    }
}
