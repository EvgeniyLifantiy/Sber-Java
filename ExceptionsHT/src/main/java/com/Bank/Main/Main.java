package com.Bank.Main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserAccount userAccount=new UserAccount("Evgeniy",1000,2134);

        TerminalServer server=new TerminalServer(userAccount);

        Scanner scanner=new Scanner(System.in);

        PinValidator pinValidator=new PinValidator(userAccount,scanner);

        Terminallmpl terminallmpl=new Terminallmpl(server,pinValidator);


        //access to  this methods should be provided after authorizations

        terminallmpl.getMoney(100);// ok

        terminallmpl.putMoney(111);//get incorrectamountexception

        terminallmpl.showBalance();

        terminallmpl.getMoney(1000);//get insufficientfundsexception



        pinValidator.verifyPin(); // test verify, call the method and enter wrong pin more than 3 times

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {  //white sometime
            e.printStackTrace();
        }

        pinValidator.verifyPin();   //try to call method but get exception



    }
}
