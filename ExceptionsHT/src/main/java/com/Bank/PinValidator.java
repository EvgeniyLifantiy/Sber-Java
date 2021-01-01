package com.Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PinValidator {

    private  String pin="1111";

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    Scanner scanner=new Scanner(System.in);

    public  String enterPin( Scanner scanner){

        String enteredPin="";

        while (enteredPin.length()<4){
            try {
                enteredPin+=scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Вводите только цифры!");
                scanner.skip("[:-~]");
            }
        }
        return enteredPin;
    }

}
