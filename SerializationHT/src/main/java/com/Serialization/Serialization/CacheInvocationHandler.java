package com.Serialization.Serialization;

import com.Serialization.Cache.Cache;
import com.Serialization.Cache.CacheType;
import com.Serialization.Cache.Choose;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CacheInvocationHandler implements InvocationHandler, Serializable {

    private final Object delegate;
    private Map<Object,Object> cacheMap=new HashMap<>();
    private final Lock lock = new ReentrantLock();

    public CacheInvocationHandler(Object delegate){
        this.delegate=delegate;
    }

    private static String getAnnotated(Method method, Object[] args) {

        List<String> annotated=new ArrayList<>();
        Parameter[] parameters=method.getParameters();//get all object annotated parameters
        for (Parameter parameter : parameters) {
            //check Choose annotation
            if (parameter.isAnnotationPresent(Choose.class)) {
                //here is parameter numbed in view \D + n,therefore regex , take it, parse to int and add to list
                int i = Integer.parseInt(parameter.getName().replaceAll("\\D", ""));
                annotated.add(args[i] + parameter.toString());
            }
        }
        return annotated.toString();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args){

        String annotated=getAnnotated(method,args);
        //if method has not annotation skip
        if (!method.isAnnotationPresent(Cache.class)) {
            try {
                return method.invoke(delegate, args);
                /*
                add description to catch
                 */

            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }


        //check
        String fileName = method.getAnnotation(Cache.class).name();
        CacheType cachetype = method.getAnnotation(Cache.class).cachetype();
        boolean isZip = method.getAnnotation(Cache.class).isZip();

        if (cachetype.equals(CacheType.FILE)) {
            //Choose place from load
            cacheMap = Serialize.load(fileName + ".zip", isZip);
        }
        //Block shared resource( Concurrent HT)
        lock.lock();
        try {
        if (!cacheMap.containsKey(annotated)) {
            Object invoke = null;
            try {
                invoke = method.invoke(delegate, args);
                  /*
                add description to catch
                 */
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            cacheMap.put(annotated, invoke);


            if (cachetype.equals(CacheType.FILE)) {
                synchronized (this) {
                    //Choose place for save
                    Serialize.save(cacheMap, fileName, isZip);
                }
            }
            return invoke;
        } else {

            //if cached successfully
            return cacheMap.get(annotated);
        }}finally {
            //unlock Shared resources
            lock.unlock();
        }
    }


}
