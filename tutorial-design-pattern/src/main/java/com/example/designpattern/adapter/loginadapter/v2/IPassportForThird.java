package com.example.designpattern.adapter.loginadapter.v2;

import com.example.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTel(String tel, String code);

    ResultMsg loginForRegist(String username, String password);
}
