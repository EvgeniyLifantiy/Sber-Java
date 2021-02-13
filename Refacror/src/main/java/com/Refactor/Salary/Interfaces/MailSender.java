package com.Refactor.Salary.Interfaces;

import javax.mail.internet.MimeMessage;

public interface MailSender {
    void sendSalaryReport(MimeMessage message);
}
