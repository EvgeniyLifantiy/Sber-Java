package com.Bank.Exceprions;

public class AccountIsLockedException extends Exception{
    public AccountIsLockedException(String message) {
        super(message);
    }
}
