package com.clase.clase03;

import java.util.ArrayList;

public class Square extends Polygons {
    private double sideSize;
    private final int sides;

    public Square() {
        this.sides = 4;
        this.questions = new ArrayList<String>();
        this.questions.add("Dame el lado del cuadrado");
    }

    @Override
    public double getArea() {
        return this.sideSize * this.sideSize;
    }

    @Override
    public double getPerimeter() {
        return this.sideSize * this.sides;
    }

    @Override
    public void setData(ArrayList<Integer> data) {
        this.sideSize = data.getFirst();
    }
}
