package com.Multithreading;

import com.Multitreading.FixedThreadPool;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FixedThreadPoolTest {


    private FixedThreadPool fixedThreadPool=new FixedThreadPool(3);

    @Test
    public void TestSingleExecute(){

        Runnable runnable= () -> System.out.println("now not empty #1");
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.execute(runnable);
        fixedThreadPool.start();
    }

    @Test
    public void TestListExecute(){
        List<Runnable> list=new ArrayList<>();
        Runnable runnable= () -> System.out.println("now not empty #2");
        list.add(runnable);
        list.add(runnable);
        list.add(runnable);
        list.add(runnable);
        list.add(runnable);
        list.add(runnable);

        fixedThreadPool.execute(list);
        fixedThreadPool.start();
    }


}
