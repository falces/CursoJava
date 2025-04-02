package com.clase.clase03;

import java.util.ArrayList;

public class Circle extends Polygons{
    private double radius;

    public Circle() {
        this.sides = 0;
        this.questions = new ArrayList<String>();
        this.questions.add("Dame el radio del círculo");
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public void setData(ArrayList<Integer> data) {
        this.radius = data.getFirst();
    }
}
