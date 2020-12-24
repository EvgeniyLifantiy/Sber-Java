package com.PECS;

import java.util.ArrayList;
import java.util.List;

import static com.PECS.CollectionUtils.*;

public class Main {
    public static void main(String[] args) {

        //


        //test newArrayList() and test addAll()
        System.out.println("-----------------------------------------------------");
        List <Integer> list=newArrayList();
        System.out.println("Сейчас лист пуст "+list);
        List<Integer> sourcelist=new ArrayList<>();
        sourcelist.add(12);
        sourcelist.add(76);
        sourcelist.add(346);
        sourcelist.add(54);
        sourcelist.add(2);
        addAll(sourcelist,list);
        System.out.println("А теперь в него перенесены все элементы "+list);

        //test limit()
        System.out.println("-----------------------------------------------------");
        List<Integer> shortlist=limit(list,3);
        System.out.println("Укороченный лист выглядит так: "+shortlist);

        // test add()
        System.out.println("-----------------------------------------------------");
        add(list,231);
        System.out.println("Теперь лист выглядит вот так: "+list);

        //test indexOf()
        System.out.println("-----------------------------------------------------");
        System.out.println("индекс элемента 76 - "+indexOf(list,76));


        //test removeAll()
        System.out.println("-----------------------------------------------------");
        removeAll(list,shortlist);
        System.out.println("После вычитания лист стал таким : "+list);



        //test containAll
        System.out.println("-----------------------------------------------------");
        System.out.println("То ,что sourcelist содержит все элементы shortlist - "+containsAll(sourcelist,shortlist));


        //test containAny
        System.out.println("-----------------------------------------------------");
        System.out.println("То,что sourcelist содержит хотя бы один элементе list - "+containsAny(sourcelist,list));

        //test range
        System.out.println("-----------------------------------------------------");
        System.out.println("Все элементы sourcelist которые больше 22 и меньше 344"+range(sourcelist,22,344));


        //test range with comparable
        System.out.println("-----------------------------------------------------");
        System.out.println("Все элементы sourcelist которые больше 22 и меньше 344"+range(list,22,344,(o1, o2) -> -1));
        // if o1 > o2 => -1,
        // o1 < o2 => 1,
        // o1 = o2 => 0


    }
}
