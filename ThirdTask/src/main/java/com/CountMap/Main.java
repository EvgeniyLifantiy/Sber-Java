package com.CountMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {




        CounMap<Integer> CountMap1= new CounMap<>();
        //test add
        CountMap1.add(234);
        CountMap1.add(54);
        CountMap1.add(654);
        CountMap1.add(54);
        CountMap1.add(3);
        CountMap1.add(54);
        CountMap1.add(543);

        System.out.println("-----------------------------------------------------");
        // test addAll and size
        CounMap<Integer> CountMap2=new CounMap<>();
        CountMap2.addAll(CountMap1);
        for (int i = 0; i <CountMap1.size() ; i++) {
            System.out.println(CountMap1.get(i));
            System.out.println(CountMap2.get(i));
        }
        System.out.println("-----------------------------------------------------");


        //test getCount
        System.out.println(CountMap1.getCount(54));
        System.out.println(CountMap1.getCount(2));
        System.out.println(CountMap1.getCount(3));

        System.out.println("-----------------------------------------------------");
        // test remove
        System.out.println("Число 54 было встречена до удаления "+CountMap1.remove(54)+" раз");
        for (int i = 0; i <CountMap1.size() ; i++) {
            System.out.println(CountMap1.get(i));
        }

        System.out.println("-----------------------------------------------------");

        //test toMap
        Map map=CountMap1.toMap();
        System.out.println(map);


        System.out.println("-----------------------------------------------------");

        //test toMap with parameters

        Map<Integer,Integer> destination= new HashMap();
        CountMap1.toMap(destination);
        System.out.println(destination);
    }
}
