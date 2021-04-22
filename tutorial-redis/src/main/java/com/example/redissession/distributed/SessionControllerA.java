package com.example.redissession.distributed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author chenpenghui
 * @date 2021-4-22
 */
@RestController
public class SessionControllerA {

    @GetMapping("/sessionA")
    public void doSomething(HttpSession session) {
        session.setAttribute("x", "y");
    }
}
