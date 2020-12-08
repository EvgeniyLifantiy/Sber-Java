package com.Shapes;

public class Square extends Figure {

    private double side;

    public Square(double side) {

        this.side = side;
    }

    public void setSide(double side ){
        if(side>0){
            this.side = side;
        }else {
            System.out.println("Сторона должна быть больше 0");
        }
    }

    public double getSide(double side){
        return side;
    }

    @Override
    public double getArea(){

        return(side*side);
    }

    @Override
    public double getPerimeter(){
        return(side*4);
    }
}
