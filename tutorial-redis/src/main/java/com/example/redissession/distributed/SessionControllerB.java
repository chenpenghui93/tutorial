package com.example.redissession.distributed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author chenpenghui
 * @date 2021-4-22
 */
@RestController
public class SessionControllerB {

    @GetMapping("/sessionB")
    public String doSomething(HttpSession session) {
        return session.getAttribute("x").toString() + "_" + session.getId();
    }
}
