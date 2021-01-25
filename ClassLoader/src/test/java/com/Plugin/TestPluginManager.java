package com.Plugin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPluginManager {

    @Test
    public void TestLoad(){


        PluginManager pluginManager1=new PluginManager(
                "D:\\Java\\ClassLoader\\src\\main\\java\\com\\Plugin\\ExamplePlugin.java");
        ExamplePlugin examplePlugin=new ExamplePlugin();
        Assert.assertEquals(examplePlugin.getClass(),
                pluginManager1.load("ExamplePlugin","com.Plugin.ExamplePlugin").getClass());
        Assert.assertEquals(pluginManager1.load(
                "ExamplePlugin","com.Plugin.ExamplePlugin").doUsefull(),
                examplePlugin.doUsefull() );



        PluginManager pluginManager2=new PluginManager(
                "D:\\Java\\ClassLoader\\src\\main\\java\\com\\Plugin\\anotherPlugin.java");
        AnotherPlugin anotherPlugin=new AnotherPlugin();
        Assert.assertEquals(anotherPlugin.getClass(),pluginManager1.load(
                "AnotherPlugin","com.Plugin.AnotherPlugin").getClass());
        Assert.assertEquals(pluginManager2.load(
                "AnotherPlugin","com.Plugin.AnotherPlugin").doUsefull(),
                anotherPlugin.doUsefull() );






    }
}

