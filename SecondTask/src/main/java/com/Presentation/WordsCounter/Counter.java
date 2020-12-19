package com.Presentation.WordsCounter;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Counter implements Comparator<String> {

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


    private static HashMap<String,Integer> wordCounter= new HashMap<>();

    public static HashMap<String, Integer> getWordCounter() {
        return wordCounter;
    }




    private  static ArrayList<String> UniqueSortedList=new ArrayList();

    public static ArrayList<String> getUniqueSortedList() {
        return UniqueSortedList;
    }




    private  static ArrayList<String> filetext=new ArrayList();

    public static ArrayList<String> getFiletext() {
        return filetext;
    }




    private static int UniqueWords;

    public static int getUniqueWords(){
        return UniqueWords;
    }





    public static String[] getText(String filepath) throws FileNotFoundException {
        File file=new File(filepath);
        Scanner scanner=new Scanner(file);
        while (scanner.hasNextLine()){
            filetext.add(scanner.nextLine());

        }
        String[] splitsrtng=splitstring(filetext.toString());
        return splitsrtng;
    }







    public static String[] splitstring(String str){
        str=str.replaceAll("[!-}\\n-]+", ""); //delete all punctuation mark

        String[] str1=str.split(" "); //convert to string array
        return str1;
    }




    public static void Count(String[] str1){ //this method count , how many every word meet in text

        wordCounter.clear();


       for (int i=0;i< str1.length;i++){
           if(str1[i].equals("")){
               continue;// if string is "space" than skip
           }
           if (wordCounter.containsKey(str1[i].toLowerCase())){ // if this word exist
               wordCounter.replace(str1[i].toLowerCase(),wordCounter.get(str1[i].toLowerCase())+1);//then increment his amount
           }  else {
               wordCounter.put(str1[i].toLowerCase(),1);//else create new key

           }
       }
    }

    public static void CountUniqueWords(String[] str){ // when we count all words we can determine how many uniaue words
        if (wordCounter.isEmpty()){
            Count(str);
        }
        UniqueWords=0;
        for (String key: wordCounter.keySet()){
            if (wordCounter.get(key)==1){
                UniqueWords++;
                UniqueSortedList.add(key);
            }
        }
    }






}
