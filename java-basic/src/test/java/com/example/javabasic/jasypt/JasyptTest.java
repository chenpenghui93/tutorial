package com.example.javabasic.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenpenghui
 * @date 2020-10-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    StringEncryptor encryptor;

    /**
     * 配置文件信息加密
     */
    @Test
    public void jasyptEncryptTest(){
        String url = encryptor.encrypt("jdbc:mysql://localhost:3306/test?useSSH=false&serverTimezone=GMT%2B8");
        String username = encryptor.encrypt("root");
        String password = encryptor.encrypt("root");
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }

    /**
     * 配置文件信息解密
     */
    @Test
    public void jasyptDecryptTest(){
        String url = "bGG7tm8+7kLojm38xlTdpWxJQEkmJQ7J81Dxvqxst9W+xipt1m4JRCHrBAFEfzllfqgOov3GhmGkLfi4HDUh4gifYjJdXbGY70HY7zNpEKprWK/YUOcMqQFYuILsYBYFB8NruftZ8kiX6crMDnJ0RA==";
        String username = "IUvBHgnU0DyPPSWfuObpmf0i/9FtTzc60leI2H2p0URZmKSEvMtavO3+E2pUeAXu";
        String password = "S1yH8TM+TcsHr/8bk+YQpVcRRBZX6aipuJU0hA9g8F1kqqSsFbNpCLt7HEX2bQ/8";
        System.out.println(encryptor.decrypt(url));
        System.out.println(encryptor.decrypt(username));
        System.out.println(encryptor.decrypt(password));

        Environment environment = context.getBean(Environment.class);
        String originUrl = environment.getProperty("spring.datasource.url");
        String originUsername = environment.getProperty("spring.datasource.username");
        String originPassword = environment.getProperty("spring.datasource.password");
        System.out.println(originUrl);
        System.out.println(originUsername);
        System.out.println(originPassword);
    }
}
