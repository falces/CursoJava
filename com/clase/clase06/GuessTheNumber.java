package com.clase.clase06;

import com.clase.exceptions.NotANumber;
import com.clase.exceptions.SelectionNotFound;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    static int number;
    static int randomNumberOfTries = 0;
    static int halfNumberOfTries = 0;
    static int minimum;
    static int maximum;
    static int randMaximum;
    static int randMinimum;
    static int halfMaximum;
    static int halfMinimum;
    static int myNumber = 0;

    public static void main(String[] args) {
        askInterval();
        askNumber();
        guessByRand();
        System.out.println("Intentos de forma aleatoria: " + randomNumberOfTries);
        myNumber = 0;
        guessByHalf();
        System.out.println("Intentos a punto medio: " + halfNumberOfTries);
    }

    private static void guessByHalf(){
        Random random = new Random();
        while(checkNumberIsNotCorrect(myNumber)){
            halfNumberOfTries++;
            if (halfMaximum - halfMinimum == 0){
                myNumber = halfMaximum;
            } else if (halfMaximum - halfMinimum == 1){
                myNumber = halfMinimum;
            } else {
                myNumber = Math.round( ((halfMaximum - halfMinimum) / 2) + halfMinimum );
            }
            if(checkNumberIsLower(myNumber)){
                halfMaximum = myNumber - 1;
            }else if(checkNumberIsHigher(myNumber)){
                halfMinimum = myNumber + 1;
            }
            guessByHalf();
        }
    }

    private static boolean checkNumberIsLower (int guessNumber){
        return guessNumber > number;
    }

    private static boolean checkNumberIsHigher (int guessNumber){
        return guessNumber < number;
    }

    private static boolean checkNumberIsNotCorrect(int guessNumber){
        return guessNumber != number;
    }

    private static void guessByRand(){
        Random random = new Random();
        while(checkNumberIsNotCorrect(myNumber)){
            randomNumberOfTries++;
            myNumber = random.nextInt((randMaximum - randMinimum) + 1) + randMinimum;
            if(checkNumberIsLower(myNumber)){
                randMaximum = myNumber - 1;
            }else if(checkNumberIsHigher(myNumber)){
                randMinimum = myNumber + 1;
            }
            guessByRand();
        }
    }

    private static void askInterval(){
        try{
            System.out.println("Dame el mínimo:");
            Scanner minInput = new Scanner(System.in);
            if(!minInput.hasNextInt()){
                throw new NotANumber(minInput.nextLine() + " no es válido");
            }
            minimum = minInput.nextInt();
            System.out.println("Dame el máximo:");
            Scanner maxInput = new Scanner(System.in);
            if(!maxInput.hasNextInt()){
                throw new NotANumber(maxInput.nextLine() + " no es válido");
            }
            maximum = maxInput.nextInt();
            if(maximum <= minimum){
                throw new SelectionNotFound("El máximo debe ser mayor que el mínimo");
            }
            randMaximum = maximum;
            halfMaximum = maximum;
            randMinimum = minimum;
            halfMinimum = minimum;
        } catch (NotANumber | SelectionNotFound e) {
            System.out.println(e.getMessage());
            askInterval();
        }
    }

    private static void askNumber(){
        try{
            System.out.println("Dime un número entre " + minimum + " y " + maximum + ":");
            Scanner input = new Scanner(System.in);
            if(!input.hasNextInt()){
                throw new NotANumber(input.nextLine() + " no es un número");
            }
            number = input.nextInt();
            if(number < minimum || number > maximum){
                throw new SelectionNotFound(number + " no es una opción válida");
            }
        } catch (NotANumber | SelectionNotFound e) {
            System.out.println(e.getMessage());
            askNumber();
        }
    }
}
