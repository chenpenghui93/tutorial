package com.example.javabasic.utils;

import java.util.Base64;

public final class Base64Util {

    public static final String CHARSET_UTF_EIGHT = "UTF-8";


    /**
     * 解密
     *
     * @param content
     * @param charset
     * @return
     * @throws Exception
     */
    public static String decode(String content, String charset) throws Exception {
        byte[] buffer = Base64.getMimeDecoder().decode(content);
        return new String(buffer, charset);
    }

    /**
     * 加密
     *
     * @param b
     * @return
     * @throws Exception
     */
    public static String encode(byte[] b) throws Exception {
        return Base64.getMimeEncoder().encodeToString(b);
    }

    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String encode(String content) throws Exception {
        return encode(content.getBytes());
    }

    /**
     * 加密
     *
     * @param content
     * @param charset
     * @return
     * @throws Exception
     */
    public static String encode(String content, String charset) throws Exception {
        return encode(content.getBytes(charset));
    }

    private Base64Util() {
    }

}
