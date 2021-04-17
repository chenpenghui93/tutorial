package com.example.designpattern.adapter.loginadapter.v2;

/**
 * @Author cph
 * @Date 2020/2/5
 */
public class PassportForThirdTest {
    public static void main(String[] args) {
        IPassportForThird pass = new PassportForThirdAdapter();
        pass.loginForQQ("111");
    }
}
