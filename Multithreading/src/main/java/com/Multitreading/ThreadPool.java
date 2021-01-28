package com.Multitreading;

public interface ThreadPool {
    void start();

    void execute(Runnable runnable);
}

