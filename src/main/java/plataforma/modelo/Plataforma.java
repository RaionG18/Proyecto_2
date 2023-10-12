package main.java.plataforma.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa la plataforma principal del sistema.
 */
public class Plataforma {
    private List<Usuario> usuarios = new ArrayList<>();

    public void registrarUsuario(Usuario usuario) {
        // Aquí se añade lógica para registrar un usuario en la plataforma.
        usuarios.add(usuario);
    }

    // Pueden agregarse otros métodos según se requiera,
    // como métodos para agregar reseñas, buscar negocios, etc.
}