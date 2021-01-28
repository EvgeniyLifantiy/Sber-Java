package com.Multitreading;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FixedThreadPool<T> implements ThreadPool{

    private final List<MyThread> threadList;

    private volatile Queue<Runnable> taskQueue=new ArrayBlockingQueue<>(1000);

    public List<MyThread> getThreadList() {
        return threadList;
    }

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
                    System.out.println("Queue is empty!");
                    return;
                }

            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        taskQueue.add(runnable);
    }

    public static void main(String[] args) {
        FixedThreadPool fixedThreadPool=new FixedThreadPool(3);
        fixedThreadPool.start();
        Runnable runnable= () -> System.out.println(System.currentTimeMillis());
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.start();



    }

}
