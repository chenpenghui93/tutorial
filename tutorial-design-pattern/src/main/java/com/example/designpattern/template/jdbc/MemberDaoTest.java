package com.example.designpattern.template.jdbc;

import java.util.List;

/**
 * @Author cph
 * @Date 2020/2/3
 */
public class MemberDaoTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
