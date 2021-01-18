package com.Reflection;

public class Calculatorlmpl implements Calculator {

    private void dosome(){

    }

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
