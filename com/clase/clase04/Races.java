package com.clase.clase04;

import com.clase.exceptions.NotANumber;
import com.clase.exceptions.SelectionNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Races {
    private static final ArrayList<String> teams = new ArrayList<String>();
    private static Integer numberOfRaces = 0;
    private static Integer numberOfTeams = 0;
    private static final ArrayList<Car> race = new ArrayList<>();
    private static final HashMap<String, Integer> results = new HashMap<>();
    private static String winner;

    public static void main(String[] args) {
        try {
            addTeams();
            askNumberOfTeams();
            askNumberOfRaces();
            manageRace();
            printResults();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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
        try {
            System.out.println("¿Cuántos equipos quieres usar?");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt()) {
                throw new NotANumber("Valor no válido (2 - 10)");
            }
            numberOfTeams = input.nextInt();
            if (numberOfTeams < 2 || numberOfTeams > 10) {
                throw new SelectionNotFound("Opción no válida (2 - 10)");
            }
        } catch (NotANumber | SelectionNotFound e) {
            System.out.println(e.getMessage());
            askNumberOfTeams();
        }
    }

    private static void askNumberOfRaces(){
        try {
            System.out.println("¿Cuántas carreras quieres disputar?");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt()) {
                throw new NotANumber("Valor no válido (1 - 10000)");
            }
            numberOfRaces = input.nextInt();
            if (numberOfRaces < 1 || numberOfRaces > 10000) {
                throw new SelectionNotFound("Opción no válida (1 - 10000)");
            }
        } catch (NotANumber | SelectionNotFound e) {
            System.out.println(e.getMessage());
            askNumberOfRaces();
        }
    }

    private static void manageRace(){
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
    }

    private static void printResults(){
        teams.forEach(
                (t) ->
                {
                    int wonRaces = (results.get(t) != null ? results.get(t) : 0);
                    if(wonRaces != 0) {
                        System.out.println(
                                t + " ha ganado " + wonRaces + " carreras " + ((wonRaces) * 100) / numberOfRaces + "%");
                    }
                }
        );
    }
}
