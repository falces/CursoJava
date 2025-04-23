package com.clase.clase07;

import java.util.Scanner;

public class WritingThings {
    public static void main(String[] args) {
        System.out.println("Nombre del archivo:");
        Scanner inputFileName = new Scanner(System.in);
        String fileName = inputFileName.nextLine();
        System.out.println("Contenido:");
        Scanner inputContent = new Scanner(System.in);
        String content = inputContent.nextLine();

        StuffInFiles stuffInFiles = new StuffInFiles(fileName);

        stuffInFiles.completeWrite(content);

        System.out.println("El contenido del archivo es:");
        System.out.println(stuffInFiles.readFile());
    }
}
