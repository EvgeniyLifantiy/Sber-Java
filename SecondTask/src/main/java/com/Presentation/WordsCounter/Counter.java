package com.Presentation.WordsCounter;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Counter implements Collection{

    @Override
    public Iterator getIterator() {
        return new StringIterator();
    }

    class StringIterator implements Iterator{
        int index=filetext.size()-1;

        @Override
        public boolean Hasnext() {
            if (index>=0) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return filetext.get(index--)   ;
        }
    }




    public String[] getText(String filepath) throws FileNotFoundException {
        File file=new File(filepath);
        Scanner scanner=new Scanner(file);
        while (scanner.hasNextLine()){
            filetext.add(scanner.nextLine());// add all lines to list

        }
        String[] splitsrtng=splitstring(filetext.toString());
        return splitsrtng;
    }

    public String[] splitstring(String str){
        str=str.replaceAll("[!-}\\n-]+", ""); //delete all punctuation mark

        String[] str1=str.split(" "); //convert to string array
        return str1;
    }




    private HashMap<String,Integer> wordCounter= new HashMap<>();

    public HashMap<String, Integer> getWordCounter() {
        return wordCounter;
    }




    private  SortedSet<String> UniqueSortedList=new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String str1, String str2) {// here we override the comparison method to compare strings in ascending order
            if (str1.length() > str2.length()) {
                return 1;
            } else if (str1.length()<str2.length()) {
                return -1;
            } else {
                return str1.compareTo(str2);
            }
        }
    });

    public SortedSet<String> getUniqueSortedList() {
        return UniqueSortedList;
    }




    private  ArrayList<String> filetext=new ArrayList();// contain text from file. 1 elem = 1 string

    public String getString(int number){return (filetext.get(number+1));}// get string by her number





    public int getWords(){
        return wordCounter.size();
    } //get amount of various words in map




    private int UniqueWords;

    public int getUniqueWords(){
        return UniqueWords;
    } // get amount of unique words in map







    public void Count(String[] str1){ //this method count , how many every word meet in text

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

    public void CountWords(String[] str){ // when we count all words we can determine how many unique words
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
