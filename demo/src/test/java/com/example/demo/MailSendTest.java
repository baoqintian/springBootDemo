package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailSendTest {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 简单邮件发送
     */
    @Test
    public void sendTest() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1372554219@qq.com");
        message.setTo("1372554219@qq.com");
        message.setSubject("今晚开会");
        message.setText("7点30半开会");
        mailSender.send(message);
    }

    /**
     * 发送邮件参杂附件
     */
    @Test
    public void sendTest2() {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("1372554219@qq.com");
            helper.setTo("1372554219@qq.com");
            helper.setSubject("今晚开会");
            helper.setText("7点30半开会");
            helper.addAttachment("Snipaste_2019-03-09_22-00-49.png", new File("C:\\Users\\zgf\\Desktop\\新建文件夹 (3)\\Snipaste_2019-03-09_22-00-49.png"));
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

}

