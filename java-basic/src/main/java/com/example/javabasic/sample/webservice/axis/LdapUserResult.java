package com.example.javabasic.sample.webservice.axis;

import lombok.Data;

import java.util.List;

/**
 * @author chenpenghui
 * @date 2020/7/21
 */
@Data
public class LdapUserResult {
    /**
     * 返回结果
     */
    private LdapToken result;

    /**
     * 用户列表
     */
    private List<LdapUser> data;
}
