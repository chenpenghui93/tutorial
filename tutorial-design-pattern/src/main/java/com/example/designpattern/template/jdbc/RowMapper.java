package com.example.designpattern.template.jdbc;

import java.sql.ResultSet;

/**
 * @Author cph
 * @Date 2020/2/3
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
