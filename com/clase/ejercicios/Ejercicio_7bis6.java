package com.clase.ejercicios;

import com.clase.exceptions.NotANumber;
import com.clase.exceptions.SelectionNotFound;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio_7bis6 {
    private static int selection;

    public static void main(String[] args) {
        try {
            while(ask()){
                Months months = new Months();
                HashMap<Integer, Month> monthData = months.getMonthsData();
                Month month = monthData.get(selection);
                System.out.println("El mes seleccionado (" + month.name() + ") tiene " + month.numberOfDays() + " días");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean ask() throws NotANumber, SelectionNotFound {
        System.out.println("Escribe un número de mes (1 - 12, 99 para salir):");
        Scanner input = new Scanner(System.in);
        if(!input.hasNextInt()){
            throw new NotANumber(input.nextLine() + " no es un número.");
        }
        selection = input.nextInt();
        if (selection != 99 && (selection < 1 || selection > 12)){
            throw new SelectionNotFound(selection + " no es válido.");
        }
        return selection != 99;
    }
}

class Months {
    private final HashMap<Integer, Month> months = new HashMap<>();
    public Months() {
        this.months.put(1, new Month("enero", 31));
        this.months.put(2, new Month("febrero", 28));
        this.months.put(3, new Month("marzo", 31));
        this.months.put(4, new Month("abril", 30));
        this.months.put(5, new Month("mayo", 31));
        this.months.put(6, new Month("junio", 30));
        this.months.put(7, new Month("julio", 31));
        this.months.put(8, new Month("agosto", 31));
        this.months.put(9, new Month("septiembre", 30));
        this.months.put(10, new Month( "octubre", 31));
        this.months.put(11, new Month("noviembre", 30));
        this.months.put(12, new Month("diciembre", 31));
    }

    public HashMap<Integer, Month> getMonthsData() {
        return this.months;
    }
}

record Month(String name, Integer numberOfDays) {
}