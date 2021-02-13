package com.Refactor.Salary.Interfaces;

import javax.mail.internet.MimeMessage;

public interface MessageBuilder {
    MimeMessage createSalaryReport(StringBuilder resultingHtml )throws Exception;
}
