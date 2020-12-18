package com.CarList;


public class Main {

    public static void main(String[] args) {


        //Test functional of class car and class clist
        //filling in manually

        CList Carlist= new CList();

        Carlist.Add("Лада ","седан");
        Carlist.Add("Лада ","хэтчбек");
        Carlist.Add("Мерседес ","седан");
        Carlist.Add("Бмв ","кроссовер");
        Carlist.Add("Форд ","хэтчбек");
        Carlist.Add("Пежо ","кроссовер");

        System.out.println(Carlist.getType("кроссовер"));


        CList Carlist1= new CList();

        Carlist1.Add("Лада ","седан");
        Carlist1.Add("Лада ","хэтчбек");
        Carlist1.Add("Мерседес ","седан");
        Carlist1.Add("Бмв ","кроссовер");
        Carlist1.Add("Форд ","хэтчбек");
        Carlist1.Add("Пежо ","кроссовер");

        System.out.println(Carlist1.getType("седан"));



        // with using Class Car

        CList Carlist2= new CList();

        Car car=new Car("Лада ","седан");
        Car car1=new Car("Лада ","хэтчбек");
        Car car2=new Car("Мерседес ","седан");
        Car car3=new Car("Бмв ","кроссовер");
        Car car4=new Car("Форд ","хэтчбек");
        Car car5=new Car("Пежо ","кроссовер");



        Carlist2.Add(car.getModel(),car.getType());
        Carlist2.Add(car1.getModel(),car1.getType());
        Carlist2.Add(car2.getModel(),car2.getType());
        Carlist2.Add(car3.getModel(),car3.getType());
        Carlist2.Add(car4.getModel(),car4.getType());
        Carlist2.Add(car5.getModel(),car5.getType());

        System.out.println(Carlist2.getType("кроссовер"));


        System.out.println(Carlist.getCarList());


    }

}
