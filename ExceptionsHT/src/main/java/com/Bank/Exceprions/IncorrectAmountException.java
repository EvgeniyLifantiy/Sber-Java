package com.Bank.Exceprions;

public class IncorrectAmountException extends Exception{
    public IncorrectAmountException(String message) {
        super(message);
    }
}
