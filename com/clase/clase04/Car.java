package com.clase.clase04;

public class Car {
    private final Integer speed;
    private final String brand;

    public Car(
        String marca
    ){
        this.brand = marca;
        this.speed = (int) (Math.random() * 200);
    }

    public Integer getSpeed() {
        return this.speed;
    }

    public String getBrand() {
        return this.brand;
    }
}
