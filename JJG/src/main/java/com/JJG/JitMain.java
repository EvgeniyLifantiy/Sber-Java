package com.JJG;

import java.util.HashMap;
import java.util.Map;

public class JitMain {
    public static void main(String[] args) {
        /*
        Start with -XX:+PrintCompilation,
        Start with -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
         */
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i< 100_000; i++){
            map.put(i, "value"+i);
        }
    }
}
