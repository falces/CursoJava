package com.clase.clase07;

public class StringClass {
    public static void main(String[] args) {
        StringBuilder mySentence = new StringBuilder("Hello, world!");
        mySentence.append(" It's a nice day");
        System.out.println(mySentence);
        System.out.println(mySentence.reverse());
        System.out.println(mySentence.delete(2,7));
    }
}
