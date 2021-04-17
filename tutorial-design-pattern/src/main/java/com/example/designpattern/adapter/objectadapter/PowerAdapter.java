package com.example.designpattern.adapter.objectadapter;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5() {
        int adapterInput = ac220.output();
        int adapterOutput = adapterInput / 44;
        System.out.println("输入" + adapterInput + "v, " + "输出" + adapterOutput + "v");
        return adapterOutput;
    }
}
