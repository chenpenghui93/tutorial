package com.example.javabasic.sample.middleware.easyrule.helloworld;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author chenpenghui
 * @date 2020/6/15
 */
public class Launcher {
    public static void main(String[] args) {
        //定义facts
        Facts facts = new Facts();
        //注册规则
        Rules rules = new Rules();
        rules.register(new HelloWorldRule());
        //创建执行引擎
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

    }
}
