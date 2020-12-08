package com.Degrees;

public class Temperature {

    private double celsius;

    public Temperature(double celsius) {

        this.celsius = celsius;
    }

    public double getCelsius(){
        return celsius;
    }

    public  void setCelsius(double celsius){
        this.celsius = celsius;
    }

    public double getKelvin(){
        return (celsius+273.15);
    }

    public double getFahrenheit(){
        return (celsius*1.8+32);
    }
}
