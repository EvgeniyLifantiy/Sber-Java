package com.Bank.Main;

import com.Bank.Exceprions.AccountIsLockedException;
import com.Bank.Exceprions.IncorrectAmountException;
import com.Bank.Exceprions.InsufficienFundsException;

public class TerminalServer {

    UserAccount userAccount;

    public TerminalServer(UserAccount userAccount){
        this.userAccount=userAccount;
    }

    int getBalance() {

        return userAccount.getBalance();


    }

    boolean putMoney (int money) throws IncorrectAmountException{

            if (money % 100 == 0) {
                userAccount.setBalance(userAccount.getBalance()+money);
                return true;
            } else {
                throw new IncorrectAmountException ("Сумма должна быть кратна 100");
            }

    }

    boolean getMoney (int money) throws InsufficienFundsException, IncorrectAmountException {
            if (money % 100 == 0) {
                if (userAccount.getBalance() >= money) {
                    userAccount.setBalance(getBalance() - money);
                    return true;
                }
                throw new InsufficienFundsException("На Вашем счёте недостаточно средств");
            } else {
                throw new IncorrectAmountException("Сумма должна быть кратна 100");
            }
    }




}
