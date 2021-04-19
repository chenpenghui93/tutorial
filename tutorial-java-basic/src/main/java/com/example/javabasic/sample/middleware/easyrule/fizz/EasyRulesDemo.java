package com.example.javabasic.sample.middleware.easyrule.fizz;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

/**
 * 规则引擎
 * http://tech.dianwoda.com/2019/06/05/gui-ze-yin-qing-easy-rulejie-shao/
 * https://github.com/j-easy/easy-rules
 *
 * @Author chenpenghui
 * @Date 2020/4/17
 */
public class EasyRulesDemo {
    public static void main(String[] args) {

        //1.创建规则执行引擎
        RulesEngineParameters parameters = new RulesEngineParameters();
        //应用当前规则时，跳过其余规则
//        parameters.skipOnFirstAppliedRule(true);
        //应用当前规则失败时，跳过其余规则
//        parameters.skipOnFirstFailedRule(true);
        //不触发规则，跳过其余规则
//        parameters.skipOnFirstNonTriggeredRule(true);
        //自定义规则的优先级超过定义的阈值时，跳过其余规则
//        parameters.setPriorityThreshold(5);
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);

        //2.注册规则
        Rules rules = new Rules();
        rules.register(new ThreeRule());
        rules.register(new EightRule());
        rules.register(new OtherRule());
        rules.register(new ThreeEightRuleUnitGroup(new ThreeRule(), new EightRule()));

        //3.执行规则
        Facts facts = new Facts();
        for (int i = 1; i <= 50; i++) {
            facts.put("number", i);
            rulesEngine.fire(rules, facts);
            System.out.println("=========================================================");
        }
    }
}
