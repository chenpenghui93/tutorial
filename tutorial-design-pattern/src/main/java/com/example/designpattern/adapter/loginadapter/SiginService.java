package com.example.designpattern.adapter.loginadapter;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public class SiginService {

    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    public ResultMsg login(String username, String password) {
        return null;
    }
}
