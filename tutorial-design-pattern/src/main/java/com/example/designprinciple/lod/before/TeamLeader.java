package com.example.designprinciple.lod.before;

import java.util.List;

/**
 * @author cph
 * @date 2019/11/16
 */
public class TeamLeader {
    public void checkNumOfCourses(List<Course> courseList) {
        System.out.println("课程数量： " + courseList.size());
    }
}
