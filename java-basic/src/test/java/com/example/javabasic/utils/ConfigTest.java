package com.example.javabasic.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenpenghui
 * @date 2021-3-2
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class ConfigTest {
    private String secret;
    private String tokenHeader;
    private String tokenPrefix;
    private String expiration;
    private String antMatchers;
}
