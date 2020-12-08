package com.Shapes;

public class Triangle extends Figure {

    private double sideA;

    private double sideB;

    private double sideC;

    public Triangle(double sideA,double sideB,double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public void setSideA(double sideA ){
        if(sideA>0){
            this.sideA = sideA;
        }else {
            System.out.println("Сторона должна быть больше 0");
        }
    }

    public void setSideB(double sideB){
        if(sideB>0){
            this.sideB = sideB;
        }else {
            System.out.println("Сторона должна быть больше 0");
        }
    }

    public void setSideC(double sideC){
        if(sideC>0){
            this.sideC = sideC;
        }else {
            System.out.println("Сторона должна быть больше 0");
        }
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double getArea(){
        double p=(sideA+sideB+sideC)/2;
        return(Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC)));
    }

    @Override
    public double getPerimeter(){
        return(sideA+sideB+sideC);
    }

}
