package com.example.javabasic.sample.middleware.easyrule.application;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenpenghui
 * @date 2020/6/15
 */
@Rule
public class SuspiciousRequestRule {

    private final String SUSPICIOUS = "suspicious";

    @Condition
    public boolean isSuspicious(@Fact("request") HttpServletRequest request) {
        return request.getParameter(SUSPICIOUS) != null;
    }

    @Action
    public void setSuspicious(@Fact("request") HttpServletRequest request) {
        request.setAttribute(SUSPICIOUS, true);
    }
}
