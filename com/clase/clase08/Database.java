package com.clase.clase08;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            ManageDatabase manageDatabase = new ManageDatabase();
            ArrayList<HashMap<String, String>> result = manageDatabase.selectData("SELECT name, phone FROM users");
            for(HashMap<String, String> row : result){
                row.keySet().forEach(
                    key -> System.out.println(key.toUpperCase() + ": " + row.get(key))
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

/*
CREATE TABLE testdb.users (
	uuid varchar(36) NOT NULL,
	name varchar(100) NOT NULL,
	email varchar(200) NOT NULL,
	phone INT(9) DEFAULT NULL NULL,
	CONSTRAINT users_pk PRIMARY KEY (uuid),
	CONSTRAINT users_unique UNIQUE KEY (email)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

insert into testdb.users values ('539e6a3b-88e2-4a46-8726-584f99dfdb8e','Pepe','pepe@gmail.com', 699999999);
insert into testdb.users values ('37e74480-e009-407c-8e4c-a4c7b4e312cd','María','maria@yahoo.es', 688888888);
insert into testdb.users values ('3b02c5b3-4232-4a4d-bbcc-db3ae5254475','Juan','juan@outlook.com', 677777777);
*/