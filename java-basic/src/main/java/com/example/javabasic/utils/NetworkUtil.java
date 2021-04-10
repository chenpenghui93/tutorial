package com.example.javabasic.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 网络工具类
 *
 * @author chenpenghui
 * @date 2020/8/14
 */
public class NetworkUtil {

    private static final Logger logger = LoggerFactory.getLogger(NetworkUtil.class);

    /**
     * 获取请求主机IP地址，若通过代理，则获取真实IP地址
     *
     * @param request
     * @return
     * @throws IOException
     */
    public final static String getIpAddress(HttpServletRequest request) throws IOException {

        String ip = request.getHeader("X-Forwarded-For");
        logger.info("getIpAddress() - X-Forwarded-For - ip=" + ip);

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                logger.info("getIpAddress() - Proxy-Client-IP - ip=" + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                logger.info("getIpAddress() - WL-Proxy-Client-IP - ip=" + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                logger.info("getIpAddress() - HTTP_CLIENT_IP - ip=" + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                logger.info("getIpAddress() - HTTP_X_FORWARDED_FOR - ip=" + ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                logger.info("getIpAddress() - getRemoteAddr - ip=" + ip);
            }
        } else if (ip.length() > 15) {
            String[] ipArray = ip.split(",");
            for (int index = 0; index < ipArray.length; index++) {
                String realIp = ipArray[index];
                if (!("unknown".equalsIgnoreCase(realIp))) {
                    ip = realIp;
                    break;
                }
            }
        }
        return ip;
    }
}
