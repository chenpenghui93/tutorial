package com.example.javabasic.utils.sendemail;

/**
 * @author cph
 * @date 2019/5/15
 */
public interface MailService {

    void sendHtmlMail(String to, String subject, String content);

}
