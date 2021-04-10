package com.example.security.controller;

import com.example.security.core.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始页
 *
 * @author chenpenghui
 * @date 2021-2-19
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/info")
    public Map<String, Object> userLogin() {
        Map<String, Object> result = new HashMap<>();
        result.put("title", "首页不需要权限、登录拦截");
        return ResultUtil.ok(result);
    }
}
