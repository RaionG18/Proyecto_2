package main.java.plataforma.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDBConnector {

    private Connection conn = null;

    // Método para establecer conexión con la base de datos SQLite
    public void connect(String filename) {
        // Asegúrate de que la ruta del archivo sea correcta y use el prefijo "jdbc:sqlite:"
        String url = "jdbc:sqlite:" + filename;

        try {
            // Establece la conexión con la base de datos
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para desconectar de la base de datos
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para leer datos de una tabla
    public void readTable(String tableName) {
        String sql = "SELECT * FROM " + tableName;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Recorrer y mostrar los resultados
            while (rs.next()) {
                // Asumiendo que la tabla tiene dos columnas 'id' y 'name'
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("nombre")+ "\t" +
                        rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
