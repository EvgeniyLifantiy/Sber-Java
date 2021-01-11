package com.Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PinValidator {

    private AccountIsLockedException accountIsLockedException;

    private boolean isAuthorized=false;

    private String pin = "1111";

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    private int wrongpin=0;

    Scanner scanner = new Scanner(System.in);

    public void validate (String enteredPin) {
        if (enteredPin.startsWith(this.pin)){
            isAuthorized=true;
            System.out.printf("Вход выполнен!");
        }else {
            wrongpin++;
        }
    }

    public void enterPin() throws Exception {

        try {
            if(wrongpin==3){
                throw accountIsLockedException;
            }
        }catch (AccountIsLockedException e){
            System.out.printf("Аккаунт заблокирован!");
            accountIsLockedException.setTime(System.currentTimeMillis());
        }

        String enteredPin = "";

        while (enteredPin.length() < 4) {


            try {
                enteredPin += scanner.nextInt();

            } catch (InputMismatchException e) {   //this exception also work when input > int
                scanner.skip("[!-~]");// skip all that was added after NaN symbol
                System.out.println("Вводите только цифры!");
            }


        }

        validate(enteredPin);

    }
}


