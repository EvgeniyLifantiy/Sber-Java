package com.Bank;



public class Terminallmpl {

    private final PinValidator pinValidator = new PinValidator();

    public PinValidator getPinValidator() {
        return pinValidator;
    }

    public Server getServer() {
        return server;
    }

    private final Server server=new Server();

    public Terminallmpl(String pin) {
        pinValidator.setPin(pin);
    }

    private static int passwordcounter=0;
}

