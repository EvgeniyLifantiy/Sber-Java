package com.Presentation;


import com.Presentation.WordsCounter.Counter;
import com.Presentation.WordsCounter.Iterator;

import java.io.FileNotFoundException;



public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //Here you can input your test path to text file
        String filepath="C:\\Users\\Евгений\\file.txt";



        Counter counter=new Counter();

        //Task 1
        counter.CountWords(counter.getText(filepath));
        System.out.println("Task 1 : Unique words in text :"+counter.getUniqueWords());
        System.out.println(" Various words in text :"+counter.getWords());

        //Task 2
        System.out.println("---------------------------------------------------");
        System.out.println("Task 2 : Display a list of different words in the file, sorted in ascending order of their length\n"
                +counter.getUniqueSortedList());

        //Task 3
        System.out.println("---------------------------------------------------");
        System.out.println("Task 3 : Count and display the number of times each word occurs in the file.");
        System.out.println(counter.getWordCounter());//  get how many times this word appeared in the text

        //Task 4 and 5
        System.out.println("---------------------------------------------------");
        System.out.println("Task 4 and 5: Create your iterator to inspection list in reverse order. " +
                "Display all file`s strings in reverse order.");
        Iterator it=counter.getIterator();

        while (it.Hasnext()) {
            System.out.println(it.next());
        }

        //Task 6
        System.out.println("---------------------------------------------------");
        System.out.println("Task 6 : Display the lines whose numbers are set by the user in any order.");
        // here you can change your string`s number
        int numberofstring=1;
        System.out.println(counter.getString(numberofstring));




    }



}
