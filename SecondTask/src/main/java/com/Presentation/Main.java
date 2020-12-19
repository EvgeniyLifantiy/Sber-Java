package com.Presentation;


import com.Presentation.WordsCounter.Counter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static com.Presentation.WordsCounter.Counter.*;


public class Main {

    public static void main(String[] args) {

        //Here you can input your test text
        String text="Преобразует все буквы в строке к нижнему регистру. Метод не применяется к знакам, отличным от букв. В следующем примере демонстрируется действие метода toLowerCase.";

        Count(text);// count every word in text
                    //so ,we must count words in text and then can show unique words or amount of every word

        //Task 1
        CountUniqueWords(text);
        System.out.println("Task 1 : Unique words in text "+getUniqueWords());

        //Task 2
        String[] strings= splitstring(text);
        Collections.sort(getUniqueSortedList(),new Counter());
        System.out.println("Task 2 :"+getUniqueSortedList());

        //Task 3
        System.out.println("Task 3 : Count and display the number of times each word occurs in the file.");
        System.out.println(getWordcounter());//  get how many times this word appeared in the text


    }



}
