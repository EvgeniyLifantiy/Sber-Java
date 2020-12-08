package com.Shapes;

public class Circle extends Figure {

    private double radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public double getArea(){
        return(2*Math.PI*radius);
    }


    @Override
    public double getPerimeter(){
        return(Math.PI*radius*radius);
     }
}
