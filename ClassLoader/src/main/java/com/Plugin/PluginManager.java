package com.Plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {

        URLClassLoader urlClassLoader = null;

        try {

            urlClassLoader = getURLClassLoader(new File(pluginRootDirectory + "\\" + pluginName), true);

        } catch (MalformedURLException e) {
            System.out.println("Incorrect path");
        } finally {

            Plugin plugin = null;
            try {
                plugin = (Plugin) urlClassLoader.loadClass(pluginClassName).newInstance();
            } catch (InstantiationException e) {
                System.out.println("Not founded default constructor");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("Access error");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Such class not founded");
                e.printStackTrace();
            }

            return plugin;
        }
    }

     URLClassLoader getURLClassLoader(File file, boolean parent) throws MalformedURLException {

        if (parent) {
            return new URLClassLoader(new URL[]{file.toURI().toURL()});
        } else {
            return new URLClassLoader(new URL[]{file.toURI().toURL()}, null);
        }
    }
}
