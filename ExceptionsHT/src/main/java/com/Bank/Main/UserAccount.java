package com.Bank.Main;

public class UserAccount {

    private String UserName="User";

    private int balance=0;

    private int pin=0000;

    private boolean isBlocked=false;

    private long blockedTime;

    public boolean isBlocked() {
        return isBlocked;
    }

    public void blockAccount(){
            isBlocked = true;
           this.blockedTime=System.currentTimeMillis();
    }

    public long getBlockedTime() {
        return blockedTime;
    }

    public void setBlockedTime(int blockedTimer) {
        this.blockedTime = blockedTimer;
    }

    public UserAccount(String Name, int balance, int pin){
        UserName=Name;
        this.balance=balance;
        this.pin=pin;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


}
