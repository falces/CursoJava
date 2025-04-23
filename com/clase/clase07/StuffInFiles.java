package com.clase.clase07;

import java.io.*;
import java.util.Scanner;

public class StuffInFiles {

    private File myFile;

    public StuffInFiles(String fileName){
        this.myFile = new File(fileName + ".txt");
    }

    public void completeWrite(
        String text
    ) {
        this.createFile();
        write(text);
    }

    private void createFile(){
        try {
            if (!this.myFile.exists()) {
                if (this.myFile.createNewFile()) {
                    System.out.println("File created: " + this.myFile.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void write(
        String text
    ) {
        try{
            FileWriter writer = new FileWriter(this.myFile, true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(text);
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFile() {
        return this.myFile;
    }

    public String readFile(){
        StringBuilder content = new StringBuilder();
        try{
            Scanner readFile = new Scanner(this.myFile);
            while(readFile.hasNext()){
                content.append(readFile.nextLine());
            }
            return content.toString();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo");
            return null;
        }
    }
}
