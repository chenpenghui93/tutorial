package com.example.security.core;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果集
 *
 * @author chenpenghui
 * @date 2020/6/14
 */
@Slf4j
public class ResultUtil extends HashMap<String, Object> {

    private static final long serialVersionUID = -1914243303483670534L;

    public ResultUtil() {
        put("code", "0");
        put("msg", "success");
    }

    /**
     * 返回默认成功消息
     *
     * @return
     */
    public static ResultUtil ok() {
        return new ResultUtil();
    }

    /**
     * 返回自定义Map
     *
     * @param map
     * @return
     */
    public static ResultUtil ok(Map<String, Object> map) {
        ResultUtil result = new ResultUtil();
        result.putAll(map);
        return result;
    }

    /**
     * 返回自定义Object
     *
     * @param obj
     * @return
     */
    public static ResultUtil ok(Object obj) {
        ResultUtil result = new ResultUtil();
        result.put("data", obj);
        return result;
    }

    /**
     * 返回自定义消息
     *
     * @param msg
     * @return
     */
    public static ResultUtil ok(String msg) {
        ResultUtil result = new ResultUtil();
        result.put("msg", msg);
        return result;
    }

    /**
     * 返回自定义编码、消息
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResultUtil error(int code, String msg) {
        ResultUtil result = new ResultUtil();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    /**
     * 返回500、自定义消息
     *
     * @param msg
     * @return
     */
    public static ResultUtil error(String msg) {
        return error(500, msg);
    }

    /**
     * 返回默认错误消息
     *
     * @return
     */
    public static ResultUtil error() {
        return error(500, "未知异常，请联系管理员");
    }

    /**
     * 使用response输出json
     *
     * @param response
     * @param map
     */
    public static void json(ServletResponse response, Map<String, Object> map) {
        PrintWriter pw = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            pw = response.getWriter();
            pw.println(JSON.toJSONString(map));
        } catch (IOException e) {
            log.error("JSON输出异常" + e);
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }

}
