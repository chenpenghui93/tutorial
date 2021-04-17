package com.example.designpattern.flyweight.general;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 * @author chenpenghui
 * @date 2021-3-27
 */
public class FlyweightFactory {

    private static Map<String, IFlyweight> pool = new HashMap<>();

    public static IFlyweight getFlyweight(String intrinsicState) {
        if (!pool.containsKey(intrinsicState)) {
            ConcreteFlyweight concreteFlyweight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState, concreteFlyweight);
        }
        return pool.get(intrinsicState);
    }

}
