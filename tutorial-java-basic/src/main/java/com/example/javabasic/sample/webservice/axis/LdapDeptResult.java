package com.example.javabasic.sample.webservice.axis;

import lombok.Data;

import java.util.List;

/**
 * @author chenpenghui
 * @date 2020/7/26
 */
@Data
public class LdapDeptResult {
    /**
     * 返回结果
     */
    private LdapToken result;

    /**
     * 部门列表
     */
    private List<LdapDept> data;
}
