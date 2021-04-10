package com.example.javabasic.sample.jdbc;

import java.sql.*;

/**
 * @author chenpenghui
 */
public class JdbcTest {
    public static void main(String[] args) {
        try {
            // 装载驱动器
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useSSH=false&serverTimezone=GMT%2B8";
            // 连接数据库
            Connection conn = DriverManager.getConnection(url, "root", "root");
            // 查询数据库
            String sql = "select * from book where id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("book_name");
                System.out.println(name);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
