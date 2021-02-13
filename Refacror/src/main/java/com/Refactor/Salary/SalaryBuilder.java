package com.Refactor.Salary;

import com.Refactor.Salary.Interfaces.MessageBuilder;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.internet.MimeMessage;


public class SalaryBuilder implements MessageBuilder {

        String recipients;

        public SalaryBuilder(String recipients){
                this.recipients=recipients;
        }

        public MimeMessage createSalaryReport(StringBuilder resultingHtml)throws Exception {

                // construct the message
                MimeMessage message = new JavaMailSenderImpl().createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setTo(recipients);
                // setting message text, last parameter 'true' says that it is HTML format
                helper.setText(resultingHtml.toString(), true);
                helper.setSubject("Monthly department salary report");

                return message;
        }
    }
    
