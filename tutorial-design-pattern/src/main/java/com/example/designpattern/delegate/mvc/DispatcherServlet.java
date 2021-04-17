package com.example.designpattern.delegate.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author cph
 * @Date 2020/2/1
 */
public class DispatcherServlet extends HttpServlet {

    public void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");
        if ("getMemberById".equals(uri)) {
            new MemberController().getMemberById(mid);
        } else if ("getOrderById".equals(uri)) {
            new OrderController().getOrderById(mid);
        } else if ("logout".equals(uri)) {
            new SystemController().logout();
        } else {
            try {
                resp.getWriter().write("404 Not Found!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        doDispatch(req, resp);
    }
}
