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

    Scanner scanner = new Scanner(System.in);

    public void enterPin() {

        String enteredPin = "";

        while (enteredPin.length() < 4) {
            try {
                enteredPin += scanner.nextInt();

            } catch (InputMismatchException e) {   //this exception also work when input > int
                scanner.skip("[!-~]");// skip all that was added after NaN symbol
                System.out.println("Вводите только цифры!");
            }
        }
        if (enteredPin.startsWith(pin)) {
            System.out.println("Пин верный!");
        }else {
            System.out.println("NO");
            enterPin();
        }

    }

}
