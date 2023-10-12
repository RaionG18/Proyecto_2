package main.java.plataforma.modelo;

/**
 * Representa una reseña o comentario hecho por un usuario sobre un negocio.
 */
public class Reseña {
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

    // Pueden agregarse otros métodos según se requiera,
    // como métodos para validar la calificación, etc.
}