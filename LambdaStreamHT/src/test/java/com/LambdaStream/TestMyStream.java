package com.LambdaStream;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class TestMyStream {

    private static List<Person> list = new ArrayList<>();

    @BeforeTest
    public static void fulfillList(){
        list.add(new Person("Nikolay",17));
        list.add(new Person("Evgeniy",24));
        list.add(new Person("Stepan",34));
    }

    @Test
    public void TestFunctional() {
        Map m = MyStream.of(list)
                .filter(person -> person.getAge() > 18)
                .transform(person -> new Person(person.getName(),person.getAge() + 100))
                .toMap(person -> person.getName(), person -> person.getAge());
        Assert.assertEquals("{Evgeniy=124, Stepan=134}",m.toString());

    }


}
