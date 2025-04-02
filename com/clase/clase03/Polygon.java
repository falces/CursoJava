package com.clase.clase03;

import java.util.ArrayList;

public interface Polygon {
    public int sides = 0;
    public double getArea();
    public double getPerimeter();
    public int getSides();
    public abstract ArrayList<String> getQuestions();
    public void setData(ArrayList<Integer> data);
}
