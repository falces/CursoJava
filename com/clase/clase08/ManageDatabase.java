package com.clase.clase08;

import com.clase.exceptions.QueryTypeNotFound;
import com.clase.tools.DotEnvReader;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ManageDatabase {

    private Statement statement;
    private Connection connection;
    private final String SELECT = "SELECT";
    private final String INSERT = "INSERT";
    private final String DELETE = "DELETE";
    private final String UPDATE = "UPDATE";
    private final String[] types = new String[]{"SELECT", "INSERT", "DELETE", "UPDATE"};

    public ManageDatabase() {
        try{
            this.openConnection();
            this.statement = this.connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void openConnection() throws ClassNotFoundException, SQLException, FileNotFoundException {
        DotEnvReader dotEnvReader = new DotEnvReader("dev");
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Crea un string de conexión: "jdbc:mysql://localhost:8306/testdb?autoReconnect=true&useSSL=false"
        String url = "jdbc:mysql://"
            + dotEnvReader.getEnvironmentVariable("SERVER")
            + ":"
            + dotEnvReader.getEnvironmentVariable("PORT")
            + "/"
            + dotEnvReader.getEnvironmentVariable("DATABASE")
            + "?autoReconnect=true&useSSL=false";
        String username = dotEnvReader.getEnvironmentVariable("USER");
        String password = dotEnvReader.getEnvironmentVariable("PASSWORD");
        this.connection = DriverManager.getConnection(url, username, password);
    }

    private String typeOfQuery(String query) throws QueryTypeNotFound {
        String[] arr = query.split(" ", 2);
        String firstWord = arr[0].toUpperCase();
        if (Arrays.asList(this.types).contains(firstWord)){
            return firstWord;
        }
        throw new QueryTypeNotFound(firstWord + " is an unhandled query type");
    }

    public ArrayList<HashMap<String, String>> selectData(String query) throws SQLException {
        ResultSet resultSet = this.statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();

        while(resultSet.next()){
            HashMap<String, String> row = new HashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                row.put(
                    resultSetMetaData.getColumnLabel(i),
                    resultSet.getString(resultSetMetaData.getColumnLabel(i))
                );
            }
            result.add(row);
        }
        this.statement.close();
        return result;
    }

}
