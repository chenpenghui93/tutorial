package com.example.designpattern.adapter.loginadapter.v2;

import com.example.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public interface login {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);

}
