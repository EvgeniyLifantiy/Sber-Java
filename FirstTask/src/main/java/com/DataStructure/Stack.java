package com.DataStructure;

    //This package contain my practise with different data structure.
    // This class is stack realization by means ArrayList Collection.

import java.util.ArrayList;

public class Stack<T> {  // Stack for all base types, will be created overload methods

    private ArrayList<T> list=new ArrayList<T>();

    public Stack(ArrayList<T> list) {
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
        return list.remove(0);
    }

}
