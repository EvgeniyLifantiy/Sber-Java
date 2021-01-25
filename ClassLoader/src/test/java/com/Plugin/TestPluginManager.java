package com.Plugin;

import com.Plugin.plugin.AnotherPlugin;
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
        com.Plugin.AnotherPlugin anotherPlugin=new com.Plugin.AnotherPlugin();
        Assert.assertEquals(anotherPlugin.getClass(),pluginManager1.load(
                "AnotherPlugin","com.Plugin.AnotherPlugin").getClass());
        Assert.assertEquals(pluginManager2.load(
                "AnotherPlugin","com.Plugin.AnotherPlugin").doUsefull(),
                anotherPlugin.doUsefull() );

        PluginManager pluginManager3=new PluginManager(
                "D:\\Java\\ClassLoader\\src\\main\\java\\com\\Plugin\\plugin\\anotherPlugin.java");
        AnotherPlugin andAnotherOnePlugin=new AnotherPlugin();
        Assert.assertEquals(andAnotherOnePlugin.getClass(),pluginManager3.load(
                "AnotherPlugin","com.Plugin.plugin.AnotherPlugin").getClass());
        Assert.assertEquals(pluginManager3.load(
                "AnotherPlugin","com.Plugin.plugin.AnotherPlugin").doUsefull(),
                andAnotherOnePlugin.doUsefull() );






    }
}

