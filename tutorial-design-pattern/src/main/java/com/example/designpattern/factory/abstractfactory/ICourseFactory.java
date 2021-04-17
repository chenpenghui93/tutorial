package com.example.designpattern.factory.abstractfactory;

import com.example.designpattern.factory.ICourse;

/**
 * @author cph
 */
//抽象的产品族，每个子工厂都要实现此接口
public interface ICourseFactory {

    //以下三个为抽象的产品等级结构
    ICourse createCourse();

    INote createNote();

    IVideo createViedo();

}
