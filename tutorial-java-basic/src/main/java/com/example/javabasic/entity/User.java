package com.example.javabasic.entity;

import lombok.Data;

/**
 * @author chenpenghui
 * @date 2020-10-24
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
