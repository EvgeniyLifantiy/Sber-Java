package com.SpringJdbc;


import org.junit.Assert;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
@ComponentScan("com.SpringJdbc")
public class Config {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        Dao dao=context.getBean(Dao.class);


        Map<String,Integer> map=new HashMap<>();
        map.put("Картошка",200);
        map.put("Молока",300);
        Recipe recipe=new Recipe("Пюре","Евгений",map);

        //adding to db
        dao.add(recipe);

        //search
        Assert.assertEquals(dao.search("Пюре"),recipe);
        Recipe recipe1= dao.search("Пюре");
        System.out.println(recipe1);
        //delete
        dao.delete("Пюре");
        //p.s. must be installed in sql Cascade delete
}
    }
