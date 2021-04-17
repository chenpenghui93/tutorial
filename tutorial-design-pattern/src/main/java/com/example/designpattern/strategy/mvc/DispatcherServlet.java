package com.example.designpattern.strategy.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author cph
 * @Date 2020/2/1
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    @Override
    public void init() {
        try {
            Class<?> memberControllerClass = MemberController.class;
            handlerMapping.add(new Handler()
                    .setController(memberControllerClass.getDeclaredConstructor().newInstance())
                    .setMethod(memberControllerClass.getMethod("getMemberById", String.class))
                    .setUrl("/web/getMemberById.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        // 1.获取用户请求的url。j2ee标准：每个url对应一个Servlet，url由浏览器输入
        String uri = req.getRequestURI();

        // 2.Servlet拿到url后做判断、选择。根据用户请求的url，去找到这个url对应的java类方法

        // 3.通过拿到的url进行handlerMapping
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }

        try {
            // 4.将具体的任务分发给method(反射调用)
            Object obj = handler.getMethod().invoke(handler.getController(), req.getParameter("mid"));

            // 5.获取method执行的结果，通过response返回
            resp.getWriter().write(obj.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        doDispatch(req, resp);
    }

    class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
