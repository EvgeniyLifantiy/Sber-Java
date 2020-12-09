package com.Degrees;

import static com.Degrees.Converter.ConvertToFahrenheit;
import static com.Degrees.Converter.ConvertToKelvin;

public class Main {
    public static void main(String[] args) {

        double celsius=12; //First way of resolve
        System.out.println("Your temperature in Kelvin: "+ConvertToKelvin(celsius)+" , in Fahrenheit: "+ConvertToFahrenheit(celsius));

        Temperature temp=new Temperature(12); //Second way of resolve
        System.out.println("Your temperature in Kelvin: "+temp.getKelvin()+" , in Fahrenheit: "+temp.getFahrenheit());


    }
}
