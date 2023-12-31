package main.java.plataforma;


import main.java.plataforma.modelo.Plataforma;
import main.java.plataforma.controlador.Controlador;
import main.java.plataforma.vista.VistaGUI;
import main.java.plataforma.database.SQLiteDBConnector;

public class PlataformaComercioLocal {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();
        VistaGUI vista = new VistaGUI(new Controlador(null, plataforma));
        Controlador controlador = new Controlador(vista, plataforma);
        SQLiteDBConnector sqLiteDBConnect = new SQLiteDBConnector();
        sqLiteDBConnect.connect("Database.db");
        vista.setVisible(true);  // Mostramos la ventana principal
        // sqLiteDBConnect.readTable("Categorias");
    }
}