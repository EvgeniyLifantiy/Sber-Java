package com.Reflection;

import org.apache.tools.ant.taskdefs.Property;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class TestAllClassMethods {

    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";

     Calculatorlmpl calculatorlmpl=new Calculatorlmpl();


    @Test
    public void TestFactorialMethod(){
        Assert.assertEquals(120,calculatorlmpl.calc(5));
        Assert.assertEquals(1,calculatorlmpl.calc(1));
        Assert.assertEquals(720,calculatorlmpl.calc(6));

    }

    @Test
    public void TestWriteAllClassMethods(){
        System.out.println(Arrays.toString(calculatorlmpl.getClass().getSuperclass().getDeclaredMethods()));//All parent`s methods
        System.out.println(Arrays.toString(calculatorlmpl.getClass().getDeclaredMethods()));// All class methods
    }

    @Test
    public void TestWriteAllClassGetters() throws IntrospectionException {
    for (PropertyDescriptor propertyDescriptor:
            Introspector.getBeanInfo(calculatorlmpl.getClass()).getPropertyDescriptors()){
            Assert.assertEquals("public final native java.lang.Class java.lang.Object.getClass()",propertyDescriptor.getReadMethod().toString());
        }
    }


    @Test
    public void TestConstants() throws IllegalAccessException {
        TestAllClassMethods testAllClassMethods=new TestAllClassMethods();
        Field[] fields= testAllClassMethods.getClass().getDeclaredFields();
        for (Field field:fields){
            if(!field.getName().equals("calculatorlmpl")) {//ignore field for tests(calculatorlmpl)
                Assert.assertEquals(field.get(testAllClassMethods), field.getName());
                System.out.println(field.getName());
            }
        }
    }

    @Test
    public void TestMetric()  {

        MetricInvocationHandler metricInvocationHandler=new MetricInvocationHandler(calculatorlmpl);

        Object[] array=new Object[]{1};
        try {
            System.out.println(metricInvocationHandler.invoke(calculatorlmpl,calculatorlmpl.getClass().getMethod("calc", int.class), array));

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}






