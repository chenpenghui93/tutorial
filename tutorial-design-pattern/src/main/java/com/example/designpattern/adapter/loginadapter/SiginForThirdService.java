package com.example.designpattern.adapter.loginadapter;

/**
 * @Author cph
 * @Date 2020/2/4
 */
public class SiginForThirdService extends SiginService {

    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId, null);
    }

    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    public ResultMsg loginForToken(String token) {
        return null;
    }

    public ResultMsg loginForTel(String tel, String code) {
        return null;
    }

    private ResultMsg loginForRegist(String username, String password) {
        super.regist(username, null);
        return super.login(username, null);
    }
}
