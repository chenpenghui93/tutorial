package com.example.designpattern.adapter.objectadapter;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public class Test {
    public static void main(String[] args) {
        /*
         * 适用场景：后期维护时使用，非软件设计阶段考虑
         * 设计思想：存在原有类，定义新接口，adapter类实现新接口并实现转换逻辑
         * 使用方法：声明新接口类，输入新参数(或原有类)，输出转换结果
         */
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5();
    }
}
