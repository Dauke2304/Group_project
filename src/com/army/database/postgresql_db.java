//information about function written in the interface where this class implenets
package com.army.database;

import java.sql.*;

public class postgresql_db implements postgresql_idb {
    @Override
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/project01";
        try {
            Class.forName("org.postgresql.Driver");
            Connection cn = DriverManager.getConnection(connectionUrl, "postgres", "did12321");

            return cn;
        } catch (Exception e) {
            System.out.println("Failed connection: " + e.getMessage());

            return null;
        }
    }
}