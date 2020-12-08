package com.Shapes;

public class Rect extends Figure {

    private double width;

    private double height;

    public Rect(double width,double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width ){
        if(width>0){
        this.width = width;
        }else {
            System.out.println("Сторона должна быть больше 0");
        }
    }

    public void setHeight(double height){
        if(height>0){
            this.height = height;
        }else {
            System.out.println("Сторона должна быть больше 0");
        }
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getArea(){
        return(2*(height*width));
    }

    @Override
    public double getPerimeter(){
        return(height*width);
    }
}
