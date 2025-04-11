package com.clase.clase04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Races {
    private static final ArrayList<String> teams = new ArrayList<String>();
    private static Integer numberOfRaces = 0;
    private static Integer numberOfTeams = 0;
    private static ArrayList<Car> race = new ArrayList<>();
    private static final HashMap<String, Integer> results = new HashMap<>();
    private static String winner;

    public static void main(String[] args) {
        addTeams();
        askNumberOfTeams();
        askNumberOfRaces();
        for(int i = 1; i <= numberOfRaces; i++){
            race.clear();
            for(int j = 0; j < numberOfTeams; j++){
                race.add(new Car(teams.get(j)));
            }
            int previousSpeed = 0;
            for(Car car : race){
                int currentSpeed = car.getSpeed();
                if (currentSpeed > previousSpeed) {
                    winner = car.getBrand();
                    previousSpeed = car.getSpeed();
                }
            }
            int currentWinnedRaces = results.getOrDefault(winner, 0);
            results.put(winner, ++currentWinnedRaces);
        }

        System.out.println(results);
    }

    private static void addTeams(){
        teams.add("Aston Martin");
        teams.add("Ferrari");
        teams.add("McLaren");
        teams.add("Red Bull");
        teams.add("Williams");
        teams.add("Mercedes");
        teams.add("Racing Bulls");
        teams.add("Haas");
        teams.add("Alpine");
        teams.add("Sauber");
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
