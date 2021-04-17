package com.example.designprinciple.dip.before;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Test {
    public static void main(String[] args) {
        Tony tony = new Tony();

        tony.studyJavaCourse();
        tony.studyPythonCourse();

        //在增加新课程后，需要修改从底层(Tony类)到高层(调用类)的所有类
        //修改原代码意味着增加风险，不够稳定
    }
}
