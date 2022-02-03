package ru.gb.lesson;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double GetArea(){
        double Area=1.0/4.0*Math.sqrt(4*Math.pow(a,2.0)*Math.pow(b,2.0)-Math.pow((Math.pow(a,2)+Math.pow(b,2)-Math.pow(c,2)),2));
        return Area;
    }
}
