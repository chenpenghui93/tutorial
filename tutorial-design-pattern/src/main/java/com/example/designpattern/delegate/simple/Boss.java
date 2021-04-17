package com.example.designpattern.delegate.simple;

/**
 * @author cph
 * @date 2019/7/18
 */
public class Boss {
    public void command(String command, Leader leader) {
        leader.doing(command);
    }
}
