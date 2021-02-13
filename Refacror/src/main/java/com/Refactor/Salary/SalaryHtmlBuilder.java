package com.Refactor.Salary;

import com.Refactor.Salary.Interfaces.ConnectionInstaller;
import com.Refactor.Salary.Interfaces.HtmlBuilder;
import com.Refactor.Salary.Interfaces.MailSender;
import com.Refactor.Salary.Interfaces.MessageBuilder;

public class SalaryHtmlBuilder {

    /*
resource - https://bitbucket.org/agoshkoviv/solid-homework/src/099989b0c76217689c4642242c87c1ac080dfc01/src/main/java/ru
/sbt/bit/ood/solid/homework/SalaryHtmlReportNotifier.java?at=master&fileviewer=file-view-default
    */


    ConnectionInstaller connectionInstaller;
    HtmlBuilder htmlBuilder;
    MessageBuilder messageBuilder;
    MailSender mailSender;

    public SalaryHtmlBuilder(ConnectionInstaller connectionInstaller, HtmlBuilder htmlBuilder,
                             MailSender mailSender, MessageBuilder messageBuilder) {

        this.connectionInstaller = connectionInstaller;
        this.htmlBuilder = htmlBuilder;
        this.mailSender = mailSender;
        this.messageBuilder = messageBuilder;
    }

    public void sendHtmlReport() throws Exception {
        mailSender.sendSalaryReport(
                messageBuilder.createSalaryReport(htmlBuilder.buildReport(
                                connectionInstaller.establishConnection()))
        );
    }
}
