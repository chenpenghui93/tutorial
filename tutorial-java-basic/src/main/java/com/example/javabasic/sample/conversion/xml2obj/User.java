package com.example.javabasic.sample.conversion.xml2obj;

/**
 * @author cph
 * @date 2019/11/7
 */
public class User {

    private long id;
    private String userName;
    private String sex;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(long id, String userName, String sex) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
