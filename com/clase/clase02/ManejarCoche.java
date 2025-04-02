package com.clase.clase02;

public class ManejarCoche {
    public static void main(String[] args) {
        Coche coche = new Coche("Toyota", 50);
        Coche coche2 = coche;
        coche.acelerar(10);
        System.out.println(coche.verCoche());
        System.out.println(coche2.verCoche());
    }
}
