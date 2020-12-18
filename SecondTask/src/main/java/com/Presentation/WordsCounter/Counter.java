package com.Presentation.WordsCounter;


import java.util.HashMap;

public class Counter {

    private HashMap<String,Integer> wordcounter= new HashMap<>();

    public HashMap<String, Integer> getWordcounter() {
        return wordcounter;
    }

    public void setWordcounter(HashMap<String, Integer> wordcounter) {
        this.wordcounter = wordcounter;
    }

    public  void Count(String str){
        str=str.replaceAll("[!-?]+", ""); //delete all punctuation mark
        String[] str1=str.split(" ");

       for (int i=0;i< str1.length;i++){
           if (wordcounter.containsKey(str1[i].toLowerCase())){ // if this word exist, then increment his amount
               wordcounter.replace(str1[i].toLowerCase(),wordcounter.get(str1[i].toLowerCase())+1);
           }  else { //else create new key
               wordcounter.put(str1[i].toLowerCase(),1);

           }
       }
    }


}
