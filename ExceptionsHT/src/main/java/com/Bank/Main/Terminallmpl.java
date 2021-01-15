package com.Bank.Main;

import com.Bank.Exceprions.AccountIsLockedException;
import com.Bank.Exceprions.IncorrectAmountException;
import com.Bank.Exceprions.InsufficienFundsException;

public class Terminallmpl implements Terminal {

    private final PinValidator pinValidator;
    private final TerminalServer server;
    private UserAccount userAccount;

    public Terminallmpl(TerminalServer server,PinValidator pinValidator) {
        this.server = server;
        this.userAccount = server.userAccount;
        this.pinValidator = pinValidator;
    }

    @Override
    public void showBalance() {
         System.out.println("Ваш баланс :"+server.getBalance());
    }

    @Override
    public void getMoney(int money) {
       try {
           server.getMoney(money);
       } catch (InsufficienFundsException e){
           System.out.println(e.getMessage());
       }catch(IncorrectAmountException e){
           System.out.println(e.getMessage());
        }

    }

    @Override
    public void putMoney(int money) {

        try {
            server.putMoney(money);
        }catch(IncorrectAmountException e){
            System.out.println(e.getMessage());
        }
    }
}
