package com.Serialization.Service;

public class Servicelmp implements Service{
    @Override
    public int MemoryWork(String name, int value) {
        return value;
    }

    @Override
    public int FileWork(String name, int value) {
        return value;
    }

    @Override
    public int ZipWork(String name, int value) {
        return value;
    }
}
