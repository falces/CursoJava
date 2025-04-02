package com.clase.clase01;

import java.util.Random;
import java.util.Scanner;

public class StonePaperScissors {
    public static void main(String[] args) {
        String[] options = {"Piedra", "Papel", "Tijeras"};
        Random random = new Random();
        int computer = random.nextInt(3) + 1;
        int user = getResponse();
        System.out.println("Usuario: " + options[user - 1] + " / Ordenador: " + options[computer - 1]);
        if (user != computer) {
            if ((user == 1 && computer == 3) || (user == 2 && computer == 1) || (user == 3 && computer == 2)){
                System.out.println(options[user - 1] + " gana a " + options[computer - 1] + ", has ganado");
            } else {
                System.out.println(options[user - 1] + " pierde con " + options[computer - 1] + ", has perdido");
            }
        } else {
            System.out.println(options[user - 1] + " vs. " + options[computer - 1] + ", empate");
        }
    }

    private static int getResponse(){
        Scanner input = new Scanner(System.in);
        System.out.println("Elige una opción");
        System.out.println("1 -> Piedra");
        System.out.println("2 -> Papel");
        System.out.println("3 -> Tijeras");
        return input.nextInt();
    }
}
