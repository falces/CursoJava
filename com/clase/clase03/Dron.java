package com.clase.clase03;

import com.clase.exceptions.NotANumber;
import com.clase.exceptions.SelectionNotFound;

import java.util.ArrayList;
import java.util.Scanner;

public class Dron {
    private static ArrayList <Polygon> polygonList;
    private static int selection;

    public static void main(String[] args) {
        try {
            ArrayList<Polygon> polygonList = new ArrayList<>();
            double area = 0;
            while(userSelection()){
                Polygon shape;
                if (selection == 1){
                    shape = new Square();
                } else if (selection == 2) {
                    shape = new Rectangle();
                } else {
                    shape = new Circle();
                }

                ArrayList<String> questions = shape.getQuestions();
                ArrayList<Integer> data = new ArrayList<Integer>();

                for (String question : questions) {
                    Scanner inputQuestion = new Scanner(System.in);
                    System.out.println(question);
                    data.add(inputQuestion.nextInt());
                }

                shape.setData(data);
                area += shape.getArea();

                System.out.println("Área acumulada: " + area);

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean userSelection() throws NotANumber, SelectionNotFound {
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectángulo");
        System.out.println("3. Círculo");
        System.out.println("¿Qué formas quieres añadir (99 para salir)?");
        Scanner input = new Scanner(System.in);
        if (!input.hasNextInt()) {
            throw new NotANumber(input.nextLine() + " no es una selección válida");
        }
        selection = Integer.parseInt(String.valueOf(input.nextInt()));
        if (selection != 1 && selection != 2 && selection != 3 && selection != 99) {
            throw new SelectionNotFound(selection + " no es válida");
        }

        return selection != 99;
    }
}
