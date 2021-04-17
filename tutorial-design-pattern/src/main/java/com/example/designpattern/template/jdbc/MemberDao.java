package com.example.designpattern.template.jdbc;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author cph
 * @Date 2020/2/3
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from t_member";
        return super.executeQuery(sql, (RowMapper<Member>) (rs, rowNum) -> {
            Member member = new Member();
            member.setUsername(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setAge(rs.getInt("age"));
            member.setAddr(rs.getString("addr"));
            return member;
        }, null);
    }
}
