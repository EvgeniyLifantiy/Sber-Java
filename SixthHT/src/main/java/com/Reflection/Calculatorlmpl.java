package com.Reflection;

public class Calculatorlmpl implements Calculator {

    /*
    testing in test root
     */


    @Metric
    @Override
    public long calc(int number) {
        long factorial=1L;
        int count=1;
        while (count<=number){
            factorial*=(count++);

        }
        return factorial;
    }


}
