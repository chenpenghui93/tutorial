package com.example.designprinciple.carp.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class OracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "Oracle连接";
    }
}
