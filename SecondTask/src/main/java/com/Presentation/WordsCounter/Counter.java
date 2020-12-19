package com.Presentation.WordsCounter;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Counter implements Comparator<String> {

    private static HashMap<String,Integer> wordcounter= new HashMap<>();

    public static ArrayList<String> getUniqueSortedList() {
        return UniqueSortedList;
    }

    private  static ArrayList<String> UniqueSortedList=new ArrayList();

    private static int UniqueWords;

    public static HashMap<String, Integer> getWordcounter() {
        return wordcounter;
    }

    public static String[] splitstring(String str){
        str=str.replaceAll("[!-?]+", ""); //delete all punctuation mark

        String[] str1=str.split(" "); //convert to string array
        return str1;
    }

    public static void Count(String str){ //this method count , how many every word meet in text

        wordcounter.clear();

        String[] str1=splitstring(str);

       for (int i=0;i< str1.length;i++){
           if (wordcounter.containsKey(str1[i].toLowerCase())){ // if this word exist
               wordcounter.replace(str1[i].toLowerCase(),wordcounter.get(str1[i].toLowerCase())+1);//then increment his amount
           }  else {
               wordcounter.put(str1[i].toLowerCase(),1);//else create new key

           }
       }
    }

    public static void CountUniqueWords(String str){ // when we count all words we can determine how many uniaue words
        UniqueWords=0;
        for (String key: wordcounter.keySet()){
            if (wordcounter.get(key)==1){
                UniqueWords++;
                UniqueSortedList.add(key);
            }
        }
    }

    public static int getUniqueWords(){
        return UniqueWords;
    }


    @Override
    public int compare(String str1,String str2) { // here we override the comparison method to compare strings in ascending order
        if (str1.length() > str2.length()) {
            return 1;
        } else if (str1.length()<str2.length()) {
            return -1;
        } else {
            return str1.compareTo(str2);
        }
    }

}
