package main.java.plataforma.controlador;

import main.java.plataforma.modelo.Plataforma;
import main.java.plataforma.modelo.Usuario;
import main.java.plataforma.vista.VistaNegocios;
import main.java.plataforma.vista.VistaGUI;

import javax.swing.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Controlador {
    private main.java.plataforma.vista.VistaGUI vista;
    private Plataforma plataforma;

    public Controlador(main.java.plataforma.vista.VistaGUI vista, Plataforma plataforma) {
        this.vista = vista;
        this.plataforma = plataforma;
    }

    public void iniciarSesion(String usuario, String contraseña) {
        System.out.println("Iniciando sesión con " + usuario);

        // Aquí añades la lógica para verificar el usuario y la contraseña.
        // Por ejemplo, podrías consultar una base de datos o un servicio externo.
        // Si las credenciales son correctas, continúas; si no, muestras un mensaje de error.

        boolean esValido = verificarCredenciales(usuario, contraseña);
        if (esValido) {
            mostrarVistaNegociosSugeridos();
        } else {
            JOptionPane.showMessageDialog(VistaGUI.getFrame(), "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean verificarCredenciales(String usuario, String contrasena) {
        String csvFile = "usuarios.csv"; // El nombre del archivo CSV

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea por comas
                String[] data = line.split(",");

                // Verificar si las credenciales coinciden
                if (data.length == 2 && data[0].equals(usuario) && data[1].equals(contrasena)) {
                    return true; // Credenciales encontradas y coinciden
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ocurrió un error al leer el archivo");
        }

        return false; // Credenciales no encontradas o no coinciden
    }

    public void registrarse(String usuario, String contraseña) {
        Usuario user = new Usuario(usuario, contraseña);
        plataforma.registrarUsuario(user);
        System.out.println("Usuario registrado con éxito");

        // Guardar los detalles del usuario en un archivo CSV
        String csvFile = "usuarios.csv"; // Nombre del archivo CSV
        boolean append = new File(csvFile).exists(); // Revisar si el archivo ya existe

        try (FileWriter fw = new FileWriter(csvFile, true); // El segundo argumento 'true' es para habilitar el modo de añadir al archivo
             PrintWriter pw = new PrintWriter(fw)) {

            if (!append) {
                // Escribir encabezados si el archivo no existía
                pw.println("Usuario,Contraseña");
            }

            // Escribir datos del usuario
            pw.println(usuario + "," + contraseña);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ocurrió un error al guardar los datos del usuario");
        }
    }

    public void mostrarVistaNegociosSugeridos() {
        VistaNegocios vistaNegocios = new VistaNegocios();
        VistaGUI.getFrame().getContentPane().removeAll();
        VistaGUI.getFrame().getContentPane().add(vistaNegocios);
        VistaGUI.getFrame().revalidate();
        VistaGUI.getFrame().repaint();
    }

}


