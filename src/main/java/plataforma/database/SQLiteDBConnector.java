package main.java.plataforma.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDBConnector{

    public static void connect(String filename)  {
        Connection conn = null;
        String URL = "D:/Documentos/UVG/Mate/Semestre 1/POO/POO P2/Proyecto_2/Database/" + filename;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        }catch (SQLException e ) {
            System.out.print(e.getMessage());

        }finally {
            try{
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException ex){
                System.out.print(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect("Database.db");
    }
}