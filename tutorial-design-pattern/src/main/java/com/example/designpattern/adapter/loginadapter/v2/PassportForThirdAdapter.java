package com.example.designpattern.adapter.loginadapter.v2;

import com.example.designpattern.adapter.loginadapter.ResultMsg;
import com.example.designpattern.adapter.loginadapter.SiginService;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public class PassportForThirdAdapter extends SiginService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQ.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechat.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForToken.class);
    }

    @Override
    public ResultMsg loginForTel(String tel, String code) {
        return processLogin(tel, LoginForTel.class);
    }

    @Override
    public ResultMsg loginForRegist(String username, String password) {
        return null;
    }

    //涉及到简单工厂模式、策略模式
    private ResultMsg processLogin(String key, Class<? extends login> clazz) {
        try {
            login adapter = clazz.getDeclaredConstructor().newInstance();
            if (adapter.support(adapter)) {
                adapter.login(key, adapter);
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
