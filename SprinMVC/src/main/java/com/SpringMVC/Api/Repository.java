package com.SpringMVC.Api;

public interface Repository {
    void addToStorage(String URL,Long data);

    Long getUrl(String url);
}
