package com.Algorithm;

import java.util.Arrays;

import static com.Algorithm.Alg.*;

public class Main {
    public static void main(String[] args) {
        int[] arr=new int[]{12,5234,56,87,54,26,91,4,7,212,131,23,5432,5645};
        BubbleSortByDesc(arr);
        System.out.println("Sorted by descending:"+Arrays.toString(arr));
        BubbleSortByAsc( arr);
        System.out.println("Sorted by ascending:"+Arrays.toString(arr));
        System.out.println("The element you are looking for has an index of "+BinarySearch(arr,12));//you can change your index here
    }
}
