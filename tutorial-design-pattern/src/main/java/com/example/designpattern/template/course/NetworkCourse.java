package com.example.designpattern.template.course;

/**
 * @Author cph
 * @Date 2020/2/3
 */
public abstract class NetworkCourse {

    protected final void createCourse() {
        // 1.发布预习资料
        this.postPreResource();

        // 2.制作课件
        this.createPPT();

        // 3.在线直播
        this.liveVideo();

        // 4.提交课件
        this.postNote();

        // 5.提交源码
        this.postSource();

        // 6.布置作业
        if (needHomeWork()) {
            checkHomeWork();
        }

    }

    abstract void checkHomeWork();

    protected boolean needHomeWork() {
        return false;
    }

    final void postSource() {
        System.out.println("提交源码");
    }

    final void postNote() {
        System.out.println("提交课件");
    }

    final void liveVideo() {
        System.out.println("直播");
    }

    final void createPPT() {
        System.out.println("制作PPT");
    }

    final void postPreResource() {
        System.out.println("发布预习资料");
    }

}
