package com.Presentation;


import com.Presentation.WordsCounter.Counter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static com.Presentation.WordsCounter.Counter.*;
import static com.Presentation.WordsCounter.Counter.getText;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //Here you can input your test path to text file
        String filepath="C:\\Users\\Евгений\\file.txt";





        //Task 1
        CountUniqueWords(getText(filepath));
        System.out.println("Task 1 : Unique words in text :"+getUniqueWords());

        //Task 2
        Collections.sort(getUniqueSortedList(),new Counter());
        System.out.println("Task 2 : Display a list of different words in the file, sorted in ascending order of their length\n"+getUniqueSortedList());

        //Task 3
        System.out.println("Task 3 : Count and display the number of times each word occurs in the file.");
        System.out.println(getWordCounter());//  get how many times this word appeared in the text


    }



}
