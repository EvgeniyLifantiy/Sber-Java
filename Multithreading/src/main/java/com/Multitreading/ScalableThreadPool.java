package com.Multitreading;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ScalableThreadPool implements ThreadPool{

    @Getter
    private  List<MyThread> threadList;

    @Getter
    private volatile Queue<Runnable> taskQueue=new ArrayBlockingQueue<>(1000);

    private int max;

    private int min;

    public ScalableThreadPool (int min, int max){
        threadList=new ArrayList<>();
        this.max=max;
        this.min=min;
        for (int i = 0; i < min; i++) {
            threadList.add(new MyThread());
        }
    }

    @Override
    public void start() {
        while (!taskQueue.isEmpty()) {
            if(taskQueue.size()>threadList.size()){
                while (threadList.size()<max & threadList.size()<taskQueue.size()){//when max or needs amount of threads
                    threadList.add(new MyThread());                                //is available start working
                }
            }
            for (MyThread thread : threadList) {
                try {
                    thread.run(taskQueue.remove());
                    System.out.println(thread.getId());
                } catch (NoSuchElementException e) {
                    break;
                }
            }
        }
        System.out.println("Queue is empty!");
        System.out.println("Amount of threads before clean " + threadList.size());
        while (threadList.size()>min){
            threadList.remove(0);//remove any thread if there are no tasks
        }
    }

    @Override
    public void execute(Runnable runnable) {
        taskQueue.add(runnable);
    }


    public void execute(List<Runnable> list) {
        taskQueue.addAll(list);
    }


}
