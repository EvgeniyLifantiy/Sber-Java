package com.Reflection;

import javax.management.ObjectName;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MetricInvocationHandler implements InvocationHandler {


    private long time;
    private final Object delegate;

    public MetricInvocationHandler(Object delegate) {
        this.delegate=delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.isAnnotationPresent(Metric.class)){

            long first=System.nanoTime();;
            Object invoke = method.invoke(delegate, args[0]);
            time = System.nanoTime() - first;
            System.out.println("Прошло времени "+time+ "наносек");
            return invoke;

        }
        return method.invoke(delegate,args);
    }
}
