package com.DataStructure;

import java.util.ArrayList;

//This package contain my practise with different data structure.
// This class is queue realization by means ArrayList Collection.

public class Queue<T> {


    private ArrayList<T> list=new ArrayList<T>();

    public Queue(ArrayList<T> list) {
        this.list = list;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    public void add(T item){
        list.add(item);
    }

    public T remove(){
        return  list.remove(0);
    }

}
