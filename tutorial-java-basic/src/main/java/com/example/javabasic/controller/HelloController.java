package com.example.javabasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenpenghui
 * @date 2020-9-7
 */
@RestController
public class HelloController {

    @GetMapping("/hi")
    public String hi(){
        return "Hello World!";
    }

    @GetMapping("/world")
    public String hello() {
        return "{\"hello\":\"world\"}";
    }

    @PostMapping("/world/{name}")
    public String hello(@PathVariable String name) {
        return "hello, " + name;
    }

    /**
     * HttpServletResponse.sendRedirect()
     *
     * @throws IOException
     */
    @GetMapping("/redirect")
    public void testRedirect() throws IOException {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.sendRedirect("http://www.baidu.com");
    }

    /**
     * "redirect:http://www.baidu.com"
     * 注意：@RestController相当于类中的所有方法都标注了@ResponseBody，这些方法会返回json对象
     * 这种情况下控制器需要使用@Controller注解
     *
     * @return
     */
    @GetMapping("/redirect1")
    public String testRedirect1() {
        return "redirect:http://www.baidu.com";
    }
}
