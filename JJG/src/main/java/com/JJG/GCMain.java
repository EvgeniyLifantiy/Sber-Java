package com.JJG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GCMain {
    static final List<Object[]> arrays = new LinkedList<>();

    public static void main(String[] args) {
        /*
        analyze how to fulfilling heap by plugin
        use each GC
         */
        for (; ; ) {
            arrays.add(new Object[100]);
        }
    }
}
