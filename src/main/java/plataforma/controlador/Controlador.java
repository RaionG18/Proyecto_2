package main.java.plataforma.controlador;

import main.java.plataforma.modelo.Plataforma;
import main.java.plataforma.modelo.Usuario;
import main.java.plataforma.vista.VistaNegocios;
import main.java.plataforma.vista.VistaGUI;

import javax.swing.*;

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

    private boolean verificarCredenciales(String usuario, String contraseña) {
        // Implementa la lógica de verificación aquí
        // Por ahora, retornamos true para simular un inicio de sesión exitoso
        return true;
    }

    public void registrarse(String usuario, String contraseña) {
        // Lógica para registrarse
        Usuario user = new Usuario(usuario, contraseña);
        plataforma.registrarUsuario(user);
        System.out.println("Usuario registrado con éxito");
        // Implementar lógica de registro aquí
    }

    public void mostrarVistaNegociosSugeridos() {
        VistaNegocios vistaNegocios = new VistaNegocios();
        VistaGUI.getFrame().getContentPane().removeAll();
        VistaGUI.getFrame().getContentPane().add(vistaNegocios);
        VistaGUI.getFrame().revalidate();
        VistaGUI.getFrame().repaint();
    }

}


