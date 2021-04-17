package com.example.javabasic.sample.webservice.axis;

import lombok.Data;

/**
 * @author chenpenghui
 * @date 2020/7/21
 */
@Data
public class LdapToken {
    /**
     * 编码
     */
    private String resCode;

    /**
     * 消息
     */
    private String resMess;

    /**
     * token
     */
    private String tokenId;

    /**
     * 过期时间
     */
    private String effecTime;
}
