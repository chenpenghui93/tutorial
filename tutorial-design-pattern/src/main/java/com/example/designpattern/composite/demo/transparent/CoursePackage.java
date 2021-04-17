package com.example.designpattern.composite.demo.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public class CoursePackage extends CourseComponent {

    private List<CourseComponent> items = new ArrayList<>();
    private String name;
    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void removeChild(CourseComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public String getName(CourseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CourseComponent cc : items) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("  ");
                }
                for (int i = 0; i < this.level; i++) {
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            cc.print();
        }
    }
}
