package com.Multithreading;

import com.Multitreading.ScalableThreadPool;
import com.Multitreading.ThreadPool;
import org.testng.annotations.Test;

public class ScalableThreadPoolTest {
    @Test
    public void TestScalability(){

            ThreadPool threadPool=new ScalableThreadPool(1,5);
            Runnable runnable= () -> System.out.println("now not empty");

            threadPool.start();// must be write that exist 1 thread

            threadPool.execute(runnable);
            threadPool.start();// must be write that exist 1 thread

            threadPool.execute(runnable);
            threadPool.execute(runnable);
            threadPool.execute(runnable);
            threadPool.start();// must be write that exist 3 thread

            threadPool.execute(runnable);
            threadPool.execute(runnable);
            threadPool.execute(runnable);
            threadPool.execute(runnable);
            threadPool.start();// must be write that exist 4 thread

    }
}
