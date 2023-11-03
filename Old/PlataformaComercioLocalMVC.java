import java.util.*;

// Modelo

/**
 * Representa a un usuario de la plataforma.
 */
class Usuario {
    private String nombre;
    private String contraseña;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Pueden agregarse otros métodos según se requiera, como métodos para validar contraseñas, etc.
}

/**
 * Representa una reseña o comentario hecho por un usuario sobre un negocio.
 */
class Reseña {
    private Usuario usuario;
    private String comentario;
    private int calificacion;

    public Reseña(Usuario usuario, String comentario, int calificacion) {
        this.usuario = usuario;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    // Pueden agregarse otros métodos según se requiera, como métodos para validar la calificación, etc.
}

// Controlador

/**
 * Controlador que maneja la interacción entre el modelo y la vista.
 */

/**
 * Clase Vista que se encarga de la interacción con el usuario.
 */
class Vista {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPrincipal() {
        System.out.println("---- Menú Principal ----");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Buscar negocios");
        System.out.println("4. Ver promociones destacadas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String[] obtenerDatosRegistro() {
        System.out.print("Nombre de usuario: ");
        String nombre = scanner.next();
        System.out.print("Contraseña: ");
        String contraseña = scanner.next();
        return new String[]{nombre, contraseña};
    }

    // Pueden agregarse otros métodos según se requiera, como métodos para mostrar reseñas, etc.
}

/**
 * Representa la plataforma principal del sistema.
 */
class Plataforma {
    private List<Usuario> usuarios = new ArrayList<>();

    public void registrarUsuario(Usuario usuario) {
        // Aquí se añade lógica para registrar un usuario en la plataforma.
        usuarios.add(usuario);
    }

    // Pueden agregarse otros métodos según se requiera, como métodos para agregar reseñas, buscar negocios, etc.
}