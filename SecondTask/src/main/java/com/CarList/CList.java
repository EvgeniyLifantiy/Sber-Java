package com.CarList;

import java.util.ArrayList;
import java.util.HashMap;

public class CList {

    private  HashMap <String,ArrayList<String>> Typelist=new HashMap<>(); // Structure for contain grouped lists

    private   ArrayList <String> CarList = new ArrayList<>();  // Main list. Contain all car.


    public  ArrayList<String> getType(String type) {
        return this.Typelist.get(type);
    }


    public  void Add (String model, String type){

        this.CarList.add(model+type);   // add all cars to main list

        if (Typelist.containsKey(type)){  //check, if exist grouped list with a key equal to the incoming one
            Typelist.get(type).add(model+type); // if true,add to existing list
        }  else {
            ArrayList<String> groupList = new ArrayList<>(); //else create new list,
            Typelist.put(type, groupList);// add to Typeslist
            groupList.add(model + type); // and add car to new grouplist

        }
    }

    public  ArrayList<String> getCarList() {
        return this.CarList;
    }

    public  void setCarList(ArrayList<String> carList) {
        this.CarList = carList;
    }

}

