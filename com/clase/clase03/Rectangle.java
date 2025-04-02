package com.clase.clase03;

import java.util.ArrayList;

public class Rectangle extends Polygons{
    private double height;
    private double width;

    public Rectangle() {
        this.sides = 4;
        this.questions = new ArrayList<String>();
        this.questions.add("Dame el lado 1");
        this.questions.add("Dame el lado 2");
    }

    @Override
    public double getArea() {
        return this.height * this.width;
    }

    @Override
    public double getPerimeter() {
        return (this.height * 2) + (this.width * 2);
    }

    @Override
    public void setData(ArrayList<Integer> data) {
        this.height = data.get(0);
        this.width = data.get(1);
    }
}
