package com.example.javabasic.sample.webservice.axis;

import lombok.Data;
import lombok.ToString;

/**
 * @author chenpenghui
 * @date 2020/7/21
 */
@Data
@ToString
public class LdapUser {
    /**
     * 员工编码
     */
    private String employeeNumber;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 职位
     */
    private String title;

    /**
     * 部门编码
     */
    private String departmentNumber;

    /**
     * 组织单元
     */
    private String ou;

    /**
     * 组织名称
     */
    private String o;

    /**
     * 用户名
     */
    private String cn;

    /**
     * 用户名英文
     */
    private String cnen;

    /**
     * 座机
     */
    private String telephoneNumber;

    /**
     * 用户类别
     */
    private String userType;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 兼职部门
     */
    private String otherDepartments;

    /**
     * 更新时间
     */
    private String udpateTime;

    /**
     * 更新时间(时间戳)
     */
    private String modifyTimestamp;
}
