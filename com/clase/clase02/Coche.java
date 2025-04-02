package com.clase.clase02;

public class Coche {
    private String marca;
    private int velocidad;

    public Coche (
            String marca,
            int velocidad
    ) {
        this.marca = marca;
        this.velocidad = velocidad;
    }

    public void acelerar (int velocidad) {
        this.velocidad += velocidad;
    }

    public String verCoche () {
        return "El coche " + this.marca + " va a " + this.velocidad + " Km/h.";
    }
}