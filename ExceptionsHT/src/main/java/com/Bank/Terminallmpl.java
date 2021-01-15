package com.Bank;


import java.util.InputMismatchException;

public class Terminallmpl {

    private final PinValidator pinValidator = new PinValidator();

    private final Server server=new Server();

    private static int passwordcounter=0;

    public PinValidator getPinValidator() {
        return pinValidator;
    }

    public Server getServer() {
        return server;
    }

    public Terminallmpl(String pin) {
        server.setPin(pin);
    }

    public void enterSymbol() throws Exception {



    }

}

