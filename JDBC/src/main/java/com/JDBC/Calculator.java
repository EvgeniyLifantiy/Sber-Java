package com.JDBC;

import java.util.List;

class Calculator {



    List<Integer> list;

    public Calculator() {
        //NOTE add load from db
    }

    @Cachable(Main.class)
    public List<Integer> Fibonacci(int n) {
        if (list.size() > n) {
            return list.subList(0,n-1);
        }
        while (list.size() <= n) {
            // count and add to list
            list.add(Calc(list.size()+1));
        }
        //NOTE add save to db
        return list;
    }

    public int Calc(int number){
        int multiply=1;

        for (int i = 1; i <= number; i++) {
            multiply*=i;
        }
        return multiply;
    }
}

