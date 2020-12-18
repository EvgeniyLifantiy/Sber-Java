package com.CarList;

public class Car {

    // Car class with only two fields - model and type. Also their getter and setter.

    private String model;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }
}
