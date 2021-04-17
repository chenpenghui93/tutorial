package com.example.designprinciple.carp.after;

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

    //这种代码结构中将具体选择交给应用层，便于进行扩展
}
