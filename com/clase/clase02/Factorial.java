package com.clase.clase02;

import com.clase.exceptions.CodeException;
import com.clase.exceptions.NotANumber;

import java.util.Scanner;

public class Factorial {
    static int result = 1;

    public static void main(String[] args) {
        try{
            System.out.println("Escribe un número:");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt()) {
                throw new NotANumber(input.nextLine() + " no es un número");
            }
            int number = input.nextInt();
            result = number;
            System.out.println("El factorial de " + number + " es " +  getFactorial(number));
        } catch (CodeException e) {
            System.out.println("Error (" + e.getCode() +"): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int getFactorial(int number) {
        if (number > 1) {
            return number * getFactorial(number - 1);
        }
        return number;
    }
}
