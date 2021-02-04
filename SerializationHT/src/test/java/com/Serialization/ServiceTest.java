package com.Serialization;

import com.Serialization.Serialization.CacheInvocationHandler;
import com.Serialization.Service.Service;
import com.Serialization.Service.Servicelmp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ServiceTest {
    @Test
    public void TestMemoryWork() {
        /*
          @Cache(name = "First", cachetype = CacheType.MEMORY)
          @Choose on value
         */

        Service delegate = new Servicelmp();
        Service service = (Service) Proxy.newProxyInstance(ClassLoader.
                        getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CacheInvocationHandler(delegate));
        service.MemoryWork("Working", 1); //new
        service.MemoryWork("Working", 2); //new
        service.MemoryWork("Working", 3); //new
        service.MemoryWork("Working", 5); //new
        service.MemoryWork("Working", 1); //cache
        service.MemoryWork("Working", 2); //cache


    }


    @Test
    public void TestFileWork(){
        /*
          @Cache(name = "Second", cachetype = CacheType.FILE)
          @Choose on value
         */

        Service delegate = new Servicelmp();
        Service service = (Service) Proxy.newProxyInstance(ClassLoader.
                        getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CacheInvocationHandler(delegate));
        service.FileWork("Working!", 1); // new
        service.FileWork("Working!", 2); // new
        service.FileWork("Working!", 2); //cache
        service.FileWork("Working!", 1);  //cache
        service.FileWork("Working!", 3);  //new
        service.FileWork("Working!", 3);  //cache
    }

    @Test
    public void zipBothParameters() {
        /*
        @Cache(name = "Third", cachetype = CacheType.FILE, isZip = true)
        @Choose on name
         */

        Service delegate = new Servicelmp();
        Service service = (Service) Proxy.newProxyInstance(ClassLoader.
                        getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CacheInvocationHandler(delegate));
        service.ZipWork("Working", 1); //new
        service.ZipWork("Working", 3); //cache
        service.ZipWork("Working faster!", 3); //new
        service.ZipWork("Stop", 3); //new
        service.ZipWork("Working", 1); //cache
        service.ZipWork("Stop", 3); //cache


    }

}
