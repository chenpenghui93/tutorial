package com.example.designpattern.prototype.shallow;

/**
 * @Author cph
 * @Date 2019/12/28
 */
public class Client {
    public ProtoType startClone(ProtoType concreteProtoType) {
        return (ProtoType) concreteProtoType.clone();
    }
}
