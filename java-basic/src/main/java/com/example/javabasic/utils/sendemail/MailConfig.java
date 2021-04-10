package com.example.javabasic.utils.sendemail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author cph
 * @date 2019/5/15
 */
@Configuration
public class MailConfig {

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // 添加发件主机域名
        mailSender.setHost("");
        mailSender.setProtocol("smtp");
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setPort(25);
        mailSender.setDefaultEncoding("UTF-8");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.timeout", "25000");
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }
}
