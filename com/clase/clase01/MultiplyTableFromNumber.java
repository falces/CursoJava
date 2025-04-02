package com.clase.clase01;

import java.util.Scanner;

public class MultiplyTableFromNumber {
    private static int contador = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        do{
            System.out.println("Escribe un número: ");
            number = input.nextInt();
        }while(!(number<=100));
        for(contador = 1; contador <= 10; contador++){
            System.out.println(number + " x " + contador + " = " + (number * contador));
        }
    }
}
