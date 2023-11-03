package main.java.plataforma.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDBConnector {
    private static final String URL = "jdbc:sqlite:path_to_your_database.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}