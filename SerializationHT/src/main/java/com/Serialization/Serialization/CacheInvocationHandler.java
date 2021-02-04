package com.Serialization.Serialization;

import com.Serialization.Cache.Choose;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheInvocationHandler implements InvocationHandler, Serializable {

    private final Object delegate;
    Map<Object,Object> cacheMap=new HashMap<>();

    public CacheInvocationHandler(Object delegate){
        this.delegate=delegate;
    }

    private static String getAnnotated(Method method, Object[] args) {

        List<String> annotated=new ArrayList<>();
        Parameter[] parameters=method.getParameters();//get all object annotated parameters
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(Choose.class)) {
                String arg = parameter.getName().replaceAll("\\D", "");
                annotated.add(args[Integer.parseInt(arg)] + parameter.toString());
            }
        }
        return annotated.toString();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  {
        String param;
        return null;
    }


}
