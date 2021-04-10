package com.example.javabasic.sample.webservice.axis;

import lombok.Data;

/**
 * @author chenpenghui
 * @date 2020/7/26
 */
@Data
public class LdapDept {
    /**
     * 部门编号
     */
    private String departmentNumber;

    /**
     * 部门名称
     */
    private String displayName;

    /**
     * 部门名称英文
     */
    private String displaynameen;

    /**
     * 排序号
     */
    private String displayid;

    /**
     * 上级部门
     */
    private String parentdepartment;

    /**
     * 部门唯一表示
     */
    private String o;

    /**
     * 部门路径
     */
    private String allo;
}
