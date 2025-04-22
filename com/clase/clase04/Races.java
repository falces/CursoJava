package com.clase.clase04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Races {
    private static final ArrayList<String> brandsInRace = new ArrayList<>();
    private static Integer numberOfRaces = 0;
    private static Integer numberOfTeams = 0;
    private static final ArrayList<Car> race = new ArrayList<>();
    private static final HashMap<String, Integer> results = new HashMap<>();
    private static String winner;

    public static void main(String[] args) {
        try{
            askNumberOfTeams();
            addTeams();
            askNumberOfRaces();
            setResults();
            for(int i = 1; i <= numberOfRaces; i++){
                setRace();
                int previousSpeed = 0;
                for(Car car : race){
                    int currentSpeed = car.getSpeed();
                    if (currentSpeed > previousSpeed) {
                        winner = car.getBrand();
                        previousSpeed = car.getSpeed();
                    }
                }
                int currentWonRaces = results.get(winner);
                results.put(winner, ++currentWonRaces);
            }
            printResults();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addTeams(){
        ArrayList<String> brands = new ArrayList<>();
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

        Random random = new Random();

        while(brandsInRace.size() < numberOfTeams) {
            int index = random.nextInt((10 - 1) + 1);
            String brand = brands.get(index);
            if (!brandsInRace.contains(brand)) {
                brandsInRace.add(brand);
            } else {
                addTeams();
            }
        }
    }

    private static void askNumberOfTeams() {
        System.out.println("¿Cuántos equipos quieres usar (2 - 10)?");
        Scanner input = new Scanner(System.in);
        numberOfTeams = input.nextInt();
        if (numberOfTeams < 2 || numberOfTeams > 10){
            System.out.println("El número de equipos debe ser entre 2 y 10");
            askNumberOfTeams();
        }
    }

    private static void askNumberOfRaces(){
        System.out.println("¿Cuántas carreras quieres disputar (1 - 1.000.000)?");
        Scanner input = new Scanner(System.in);
        numberOfRaces = input.nextInt();
        if (numberOfRaces < 1 || numberOfTeams > 100000){
            System.out.println("El número de carreras debe estar entre 1 y 1.000.000");
            askNumberOfRaces();
        }
    }

    private static void setResults(){
        for(int j = 0; j < numberOfTeams; j++){
            results.put(brandsInRace.get(j), 0);
        }
    }

    private static void setRace(){
        race.clear();
        for(int j = 0; j < numberOfTeams; j++){
            race.add(new Car(brandsInRace.get(j)));
        }
    }

    private static void printResults(){
        for(String brand : results.keySet()){
            int numberOfVictories = results.get(brand);
            double percentage = (double)(100 * numberOfVictories) / numberOfRaces;
            System.out.println(brand + ": " + results.get(brand) + " victorias (" + percentage + "%)");
        }
    }
}
