package com.example.designprinciple.dip.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Tony {
    public void study(ICourse course) {
        course.study();
    }
}
