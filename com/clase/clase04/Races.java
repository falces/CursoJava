package com.clase.clase04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Races {
    private static final ArrayList<String> brands = new ArrayList<String>();
    private static Integer numberOfRaces = 0;
    private static Integer numberOfTeams = 0;
    private static ArrayList<Car> race = new ArrayList<>();
    private static HashMap<String, Integer> results = new HashMap<>();
    private static String winner;

    public static void main(String[] args) {
        addTeams();
        askNumberOfTeams();
        askNumberOfRaces();
        for(int i = 1; i <= numberOfRaces; i++){
            for(int j = 1; j <= numberOfTeams; j++){
                race.add(new Car(brands.get(j)));
            }
            int previousSpeed = 0;
            for(Car car : race){
                int currentSpeed = car.getSpeed();
                if (currentSpeed > previousSpeed) {
                    winner = car.getBrand();
                    previousSpeed = car.getSpeed();
                }
            }
            int currentWinnedRaces = (winner != null) ? results.get(winner) : 0;
            results.put(winner, ++currentWinnedRaces);
        }

        System.out.println(results);
    }

    private static void addTeams(){
        brands.add("Aston Martin");
        brands.add("Ferrari");
        brands.add("McLaren");
        brands.add("Red Bull");
        brands.add("Williams");
        brands.add("Mercedes");
        brands.add("Racing Bulls");
        brands.add("Haas");
        brands.add("Alpine");
        brands.add("Sauber");
    }

    private static void askNumberOfTeams() {
        System.out.println("¿Cuántos equipos quieres usar?");
        Scanner input = new Scanner(System.in);
        numberOfTeams = input.nextInt();
    }

    private static void askNumberOfRaces(){
        System.out.println("¿Cuántas carreras quieres disputar?");
        Scanner input = new Scanner(System.in);
        numberOfRaces = input.nextInt();
    }
}
