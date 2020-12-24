package com.PECS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {



    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return (new ArrayList<T>());
    }

    public static <T> int indexOf(List<T> source, T elem) {
        return source.indexOf(elem);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        List<T> destination=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            destination.add(source.get(i));
        }

        return destination;
    }

    public static <T>void add(List<? super T> source, T elem) {
        source.add(elem);
    }

    public static <T>void removeAll(List<? extends T> removeFrom, List<? super T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        if (c1.containsAll(c2)){
            return true;
        }
        return false;
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T elem:c2) {
           if(c1.contains(elem)){
               return true;
           }
        }
        return false;

    }

    public static<T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {

        List<T> rangelist=new ArrayList<>();
        for (T elem :list){
            if ((elem.compareTo(min) >= 0) && (elem.compareTo(max) <= 0)){
                rangelist.add(elem);
            }
        }

        return rangelist;

    }

     public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
         List<T> rangelist=new ArrayList<>();
         for (T elem :list){
             if ((comparator.compare(elem, min) <= 0) && (comparator.compare(elem, max) >= 0)){
                 rangelist.add(elem);
             }

         }

         return rangelist;
    }
}

