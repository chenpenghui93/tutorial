package com.example.designpattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cph
 * @date 2019/7/18
 */
public class Leader {

    private Map<String, IEmployee> register = new HashMap<>();

    public Leader() {
        register.put("编码", new EmployeeA());
        register.put("测试", new EmployeeB());
    }

    public void doing(String command) {
        register.get(command).doing(command);
    }
}
