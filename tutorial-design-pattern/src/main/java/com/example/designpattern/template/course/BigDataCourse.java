package com.example.designpattern.template.course;

/**
 * @Author cph
 * @Date 2020/2/3
 */
public class BigDataCourse extends NetworkCourse {

    private boolean needHomeWorkFlag;

    public BigDataCourse(boolean needHomeWorkFlag) {
        this.needHomeWorkFlag = needHomeWorkFlag;
    }

    @Override
    void checkHomeWork() {
        System.out.println("检查大数据作业");
    }

    @Override
    protected boolean needHomeWork() {
        return this.needHomeWorkFlag;
    }
}
