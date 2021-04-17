package com.example.designprinciple.lod.before;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Boss {
    public void commandCheckNum(TeamLeader teamLeader) {
        //模拟查询，teamLeader统计
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        teamLeader.checkNumOfCourses(courseList);
    }
}
