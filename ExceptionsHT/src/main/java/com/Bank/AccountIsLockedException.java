package com.Bank;

public class AccountIsLockedException extends Exception {


        private long time=0;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
