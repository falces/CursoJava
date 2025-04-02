package com.clase.clase02;

import com.clase.exceptions.NotANumber;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        try {
            System.out.println("Escribe números separados por comas:");
            Scanner input = new Scanner(System.in);

            String[] inputNumbers = input.nextLine().split(",");

            int odds = 0;
            double evens = 1;

            ArrayList<String> oddNumbers = new ArrayList<String>();
            ArrayList<String> evenNumbers = new ArrayList<String>();

            //  for (int i = 0; i < inputNumbers.length; i++) {
            for (String inputNumber : inputNumbers) {
                // inputNumber = inputNumbers[i]
                inputNumber = inputNumber.trim();

                if (!isNumeric(inputNumber)){
                    throw new NotANumber(inputNumber + " no es un número");
                }

                int number = Integer.parseInt(inputNumber);
                if (isOdd(number)) {
                    oddNumbers.add(inputNumber);
                    odds += number;
                } else {
                    evenNumbers.add(inputNumber);
                    evens *= number;
                }
            }

            System.out.println("Los números pares " + oddNumbers + " suman: " + odds);
            System.out.println("Los números impares " + evenNumbers + " multiplican: " + evens);
        } catch (NotANumber e) {
            System.out.println("Error (" + e.getCode() +"): " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static boolean isOdd(int number) {
        return number % 2 == 0;
    }
}
