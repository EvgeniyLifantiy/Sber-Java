package com.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class main {
    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);

        AbsTractor absTractor=context.getBean(AbsTractor.class);

        absTractor.moveForwards();

        System.out.println("hello");

    }
}
