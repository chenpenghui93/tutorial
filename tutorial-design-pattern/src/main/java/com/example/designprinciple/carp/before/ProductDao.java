package com.example.designprinciple.carp.before;

/**
 * @author cph
 * @date 2019/11/16
 */
public class ProductDao {

    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct() {
        String conn = dbConnection.getConnection();
        System.out.println("使用" + conn + "增加产品");
    }

    //这种代码结构中DBConnection不是一种抽象，不便于系统扩展。当需要增加Oracle连接时需要修改原代码，违背了开闭原则
}
