package com.SpringMVC.Services;

import com.SpringMVC.Api.Repository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.WeakHashMap;

@Component
public class WeakRepository implements Repository {

    Map<String,Long> storage=new WeakHashMap();

    @Override
    public void addToStorage(String URL,Long data) {
        storage.put(URL,data);
    }


    public Long getUrl(String url){
       return storage.get(url);
    }


}
