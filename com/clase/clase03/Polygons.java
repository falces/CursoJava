package com.clase.clase03;

import java.util.ArrayList;

abstract public class Polygons implements Polygon {
    protected ArrayList<String> questions;
    protected int sides;

    @Override
    public int getSides() {
        return Polygon.sides;
    }

    @Override
    public ArrayList<String> getQuestions(){
        return this.questions;
    };
}
