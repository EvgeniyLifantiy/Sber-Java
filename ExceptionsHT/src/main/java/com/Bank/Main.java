package com.Bank;

public class Main {
    public static void main(String[] args) throws Exception {

     Terminallmpl terminallmpl= new Terminallmpl("2349");

        System.out.println(terminallmpl.getPinValidator().getPin());
                terminallmpl.getPinValidator().enterPin();
    }
}
