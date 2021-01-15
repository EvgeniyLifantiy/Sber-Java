package com.Bank;

import java.util.InputMismatchException;

public class Server {

    private AccountIsLockedException accountIsLockedException= new AccountIsLockedException();

    private String pin = "1111";

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    private int wrongpin=3;

    public void checkPassword (String enteredPin) {
        if (enteredPin.startsWith(this.pin)){

            System.out.printf("Вход выполнен!");
        }else {
            wrongpin++;
            System.out.printf("Неверный пароль!");
        }
    }




}
