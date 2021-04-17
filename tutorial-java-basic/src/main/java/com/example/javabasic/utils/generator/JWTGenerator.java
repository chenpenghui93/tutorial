package com.example.javabasic.utils.generator;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT(JSON Web Token),跨域认证解决方案
 * http://www.ruanyifeng.com/blog/2018/07/json_web_token-tutorial.html
 * JWT数据结构：Header.Payload.Signature
 *
 * @Author cph
 * @Date 2020/1/17
 */
public class JWTGenerator {

    /**
     * 密钥
     */
    private static final String SECRET = "hello world";

    /**
     * 生成token
     *
     * @return token
     * @throws UnsupportedEncodingException
     */
    public static String createToken() throws UnsupportedEncodingException {

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)
                .withClaim("act", "act")
                .withClaim("pwd", "pwd")
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    /**
     * 校验token
     *
     * @param token
     * @param key
     * @return
     * @throws UnsupportedEncodingException
     */
    public static boolean verifyToken(String token, String key) throws UnsupportedEncodingException {

        System.out.println("key: " + key);

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        Map<String, Claim> claimMap = decodedJWT.getClaims();
        String account = claimMap.get("act").asString();
        System.out.println("account: " + account);
        String password = claimMap.get("pwd").asString();
        System.out.println("password: " + password);

        if ("act".equals(account) && "pwd".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    //test
    public static void main(String[] args) {
        try {
            String token = createToken();
            System.out.println("token: " + token);
            boolean isValid = verifyToken(token, SECRET);
            System.out.println("isValid: " + isValid);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
