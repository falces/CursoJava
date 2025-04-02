package com.clase.clase01;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        while(userWantsToProceed()){
            int number = getNumber();
            if(isOdd(number)){
                print("Es par");
            } else {
                print("Es impar");
            }
        }
    }

    private static boolean userWantsToProceed(){
        Scanner input = new Scanner(System.in);
        print("¿Quiere operar (s/n)?");
        String answer = input.nextLine();
        return answer.equalsIgnoreCase("s");
    }

    private static int getNumber(){
        print("Escribe un número:");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static boolean isOdd(int number){
        return number%2 == 0;
    }

    private static void print(String text){
        System.out.println(text);
    }
}
