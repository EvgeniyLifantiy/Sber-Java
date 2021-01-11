package com.Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PinValidator {

    private String pin = "1111";

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    private int wrongpin=0;

    Scanner scanner = new Scanner(System.in);

    public boolean enterPin() throws Exception {

        String enteredPin = "";

        while (enteredPin.length() < 4) {


            try {
                enteredPin += scanner.nextInt();

            } catch (InputMismatchException e) {   //this exception also work when input > int
                scanner.skip("[!-~]");// skip all that was added after NaN symbol
                System.out.println("Вводите только цифры!");
            }


        }



        if (enteredPin.startsWith(pin) && this.wrongpin<3) {

            System.out.println("Пин верный!");
            return true;

        }else {

            System.out.printf("Неверно");
            this.wrongpin++;

            try {
                System.out.printf(String.valueOf(this.wrongpin));
                if(this.wrongpin>=3){
                    throw new AccountIsLockedException();
                }else {
                    enterPin();
                }

            }catch (AccountIsLockedException e){
                if(e.getStartlock()==0 && wrongpin==3){
                    e.setStartlock(System.currentTimeMillis());
                }
                System.out.printf("Account was blocked! Wait " + (System.currentTimeMillis()-e.getStartlock()));
                enterPin();
            }
        }

    return false;
    }
}
