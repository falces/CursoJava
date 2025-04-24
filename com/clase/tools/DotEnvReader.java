package com.clase.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DotEnvReader {
    private final HashMap<String, String> environmentVariables = new HashMap<String, String>();

    public DotEnvReader(String environment) throws FileNotFoundException {
        File dotEnv = new File(".env");
        Scanner readFile = new Scanner(dotEnv);
        while(readFile.hasNext()){
            String[] parts = readFile.nextLine().split("=");
            this.environmentVariables.put(parts[0], parts[1]);
        }
    }

    public String getEnvironmentVariable(String variableName) {
        return this.environmentVariables.get(variableName);
    }
}
