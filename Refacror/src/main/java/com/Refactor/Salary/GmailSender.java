package com.Refactor.Salary;

import com.Refactor.Salary.Interfaces.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.internet.MimeMessage;

public class GmailSender implements MailSender {

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    public void sendSalaryReport(MimeMessage message)  {
        //set host
        mailSender.setHost("mail.google.com");
        mailSender.send(message);
    }
}
