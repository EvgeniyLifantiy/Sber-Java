package com.Multitreading;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FixedThreadPool<T> implements ThreadPool{

    @Getter
    private final List<MyThread> threadList;

    @Getter
    private volatile Queue<Runnable> taskQueue=new ArrayBlockingQueue<>(1000);



    public FixedThreadPool (int amount){
        threadList=new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            threadList.add(new MyThread());
        }
    }

    public FixedThreadPool (List<MyThread> threadList){
        this.threadList=threadList;
    }

    @Override
    public void start() {
        while (!taskQueue.isEmpty()) {
            for (MyThread thread : threadList) {
                try {
                    System.out.println(thread.getId());
                    thread.run(taskQueue.remove());
                } catch (NoSuchElementException e) {
                    break;
                }

            }
        }
        System.out.println("Queue is empty!");
    }

    @Override
    public void execute(Runnable runnable) {
        taskQueue.add(runnable);
    }


    public void execute(List<Runnable> list) {
        taskQueue.addAll(list);
    }



}
