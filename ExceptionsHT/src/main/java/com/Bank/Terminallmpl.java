package com.Bank;



public class Terminallmpl {

    private final PinValidator pinValidator = new PinValidator();

    private final Server server=new Server();

    public Terminallmpl(String pin) {
        pinValidator.setPin(pin);
    }


}

