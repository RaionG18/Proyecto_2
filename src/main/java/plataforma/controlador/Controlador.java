package main.java.plataforma.controlador;

import main.java.plataforma.modelo.Plataforma;
import main.java.plataforma.modelo.Usuario;

public class Controlador {
    private main.java.plataforma.vista.VistaGUI vista;
    private Plataforma plataforma;

    public Controlador(main.java.plataforma.vista.VistaGUI vista, Plataforma plataforma) {
        this.vista = vista;
        this.plataforma = plataforma;
    }

    public void iniciarSesion(String usuario, String contraseña) {
        // Aquí añades lógica para iniciar sesión, por ahora solo imprime
        System.out.println("Iniciando sesión con " + usuario);
        // Implementar lógica de inicio de sesión aquí
    }

    public void registrarse(String usuario, String contraseña) {
        // Lógica para registrarse
        Usuario user = new Usuario(usuario, contraseña);
        plataforma.registrarUsuario(user);
        System.out.println("Usuario registrado con éxito");
        // Implementar lógica de registro aquí
    }

    // ... [Otros métodos según se requieran] ...
}


