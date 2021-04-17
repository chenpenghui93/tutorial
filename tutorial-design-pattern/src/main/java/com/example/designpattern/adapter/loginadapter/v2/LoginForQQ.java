package com.example.designpattern.adapter.loginadapter.v2;

import com.example.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public class LoginForQQ implements login {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQ;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
