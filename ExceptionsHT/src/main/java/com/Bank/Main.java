package com.Bank;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

     Terminallmpl terminallmpl= new Terminallmpl("2349");

        int c= 0;
        try {
            c = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(c);

    }
}
