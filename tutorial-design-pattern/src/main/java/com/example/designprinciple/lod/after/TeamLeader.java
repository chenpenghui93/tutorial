package com.example.designprinciple.lod.after;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cph
 * @date 2019/11/16
 */
public class TeamLeader {
    public void checkNumOfCourses() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("课程数量： " + courseList.size());
    }
}
