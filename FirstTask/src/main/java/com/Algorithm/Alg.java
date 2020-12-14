package com.Algorithm;

public class Alg {
    public static void BubbleSortByAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int bouble = arr[j];
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = bouble;
                }
            }
        }
    }

    public static void BubbleSortByDesc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                int bouble = arr[j];
                if (arr[j] < arr[j + 1])
                {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = bouble;
                }
            }
        }
    }

    public static int BinarySearch(int[] arr, int find){
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int mid=(start+end)/2;
            if (arr[mid]<find){
                start=mid+1;
            } else if(arr[mid]>find){
                end=mid-1;
            } else if(arr[mid]==find){
                return mid;}

        }
        return  0;
    }
}
