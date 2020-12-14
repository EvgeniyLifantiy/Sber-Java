package com.Degrees;

public class Converter {



    static public double ConvertToKelvin(double celsius){
        return (celsius+273.15);
    }

    static public double ConvertToFahrenheit(double celsius){
        return (celsius*1.8+32);
    }

}
