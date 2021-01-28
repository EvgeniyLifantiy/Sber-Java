package com.Multitreading;

public class MyThread extends Thread{

    public void run(Runnable runnable) {
       runnable.run();
    }



}
