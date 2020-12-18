package com.Presentation;

import com.Presentation.WordsCounter.Counter;


public class Main {

    public static void main(String[] args) {

        //Here you can input your test text
        String text="Преобразует все буквы в строке к нижнему регистру. Метод toLowerCase не применяется к знакам, отличным от букв. В следующем примере демонстрируется действие метода toLowerCase.";
        Counter counter =new Counter();
        counter.Count(text);
        System.out.println(counter.getWordcounter());
    }



}
