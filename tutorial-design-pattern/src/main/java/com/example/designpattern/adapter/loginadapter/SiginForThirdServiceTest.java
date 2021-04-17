package com.example.designpattern.adapter.loginadapter;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public class SiginForThirdServiceTest {
    public static void main(String[] args) {
        SiginForThirdService service = new SiginForThirdService();

        //原有方式
        service.regist("aaa", "aaa");
        service.login("aaa", "aaa");

        //新方式
        service.loginForQQ("tttt");
        service.loginForTel("111", "111");
    }
}
