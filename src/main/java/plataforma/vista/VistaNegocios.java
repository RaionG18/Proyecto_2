package main.java.plataforma.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VistaNegocios extends JPanel {
    public VistaNegocios() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Negocios Sugeridos");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);

        // Lista de nombres de empresas ficticias
        // String[] nombresEmpresas = {"TechSoluciones", "AgroCampo", "EcoVida", "AutoInnovar", "GastroDelicias"};
        // Leer los nombres de las empresas desde el archivo CSV
        String[] nombresEmpresas = leerNombresEmpresasDesdeCSV();

        // Crear y añadir botones para cada empresa
        for (String nombreEmpresa : nombresEmpresas) {
            JButton botonEmpresa = new JButton(nombreEmpresa);
            botonEmpresa.setFont(new Font("Arial", Font.PLAIN, 16));

            // Definir y añadir un ActionListener para cada botón
            botonEmpresa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica al hacer clic en el botón
                    System.out.println("Botón presionado: " + nombreEmpresa);
                    mostrarInformacionTienda(nombreEmpresa);
                }
            });

            this.add(botonEmpresa);
        }
    }

    // Método para mostrar información de la tienda
    private void mostrarInformacionTienda(String nombreEmpresa) {
        // Descripción ficticia de la tienda
        String descripcion = "Descripción de " + nombreEmpresa + ": Una tienda líder en su campo con una amplia gama de productos y servicios.";

        // Generar un inventario aleatorio de productos
        String[] productos = {"Producto A", "Producto B", "Producto C", "Producto D", "Producto E"};
        int cantidadProductos = (int) (Math.random() * productos.length) + 1;

        // Generar calificación aleatoria
        int calificacion = (int) (Math.random() * 5) + 1; // Calificación de 1 a 5

        // Reseñas ficticias
        String[] reseñas = {
                "Excelente servicio y calidad de productos.",
                "Muy satisfecho con mi compra, lo recomiendo.",
                "Buenos precios, pero el servicio al cliente podría mejorar.",
                "Variedad interesante, pero la entrega fue más lenta de lo esperado.",
                "Increíble experiencia, definitivamente volveré a comprar aquí."
        };
        int cantidadReseñas = (int) (Math.random() * reseñas.length) + 1;

        // Mostrar información en la consola
        System.out.println("\nInformación de la tienda: " + nombreEmpresa);
        System.out.println(descripcion);
        System.out.println("Calificación: " + calificacion + " estrellas");
        System.out.println("Inventario de Productos:");
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("- " + productos[i]);
        }
        System.out.println("Reseñas:");
        for (int i = 0; i < cantidadReseñas; i++) {
            System.out.println((i + 1) + ". " + reseñas[i]);
        }
    }

    private String[] leerNombresEmpresasDesdeCSV() {
        ArrayList<String> nombres = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("empresas.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                nombres.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombres.toArray(new String[0]);
    }
}

