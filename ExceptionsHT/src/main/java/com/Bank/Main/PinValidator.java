package com.Bank.Main;

import com.Bank.Exceprions.AccountIsLockedException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PinValidator {

    private int pin;

    private UserAccount userAccount;

    private Scanner scanner;

    public PinValidator(UserAccount userAccount, Scanner scanner) {
        this.pin = userAccount.getPin();
        this.userAccount = userAccount;
        this.scanner = scanner;
    }

    public boolean verifyPin() {
        try {
        if(userAccount.isBlocked()){
            if (System.currentTimeMillis()< userAccount.getBlockedTime()+10000){ //while lefttime >10 seconds
                float lefttime=(userAccount.getBlockedTime()+10000-System.currentTimeMillis())/1000;
                    throw new AccountIsLockedException("Доступ закрыт, осталось времени блокировки:"+lefttime+"сек");
            }
        }
        }catch (AccountIsLockedException e){
            System.out.println(e.getMessage());
            return false;
        }

        String Pin="";

        int attemptCount=0;// count of login attempt

        int index=0; // symbols of pin

        boolean notnumber=false;

        while (attemptCount<3){
            while (index<4){
                try{
                    Pin+=scanner.nextInt(); // add only int else Exception
                    index=Pin.length(); // user write by one symbol but can write all
                }catch (InputMismatchException e){
                    scanner.skip("[@-}]"); //skip NaN
                }finally {
                    if(notnumber){
                        System.out.println("Вводите только цифры!");
                    }
                }
            }
            if (index>=4){
                    if(Integer.toString(pin).startsWith(Pin)){
                        System.out.println("Вход выполнен");
                        return true;
                    }else {
                        System.out.println("Неверный пароль");
                        attemptCount++;
                        index=0;
                    }

            }
        }
    userAccount.blockAccount();// more than 3 wrongpin
    return false;
    }

}
