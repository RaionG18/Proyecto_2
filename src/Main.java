import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PlataformaComercioLocal {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();
        Negocio negocio = new Negocio("Tienda Local", "Calle Principal 123", "9am - 7pm", "Tienda");
        Consumidor consumidor = new Consumidor("Juan", "Calle Secundaria 456");

        plataforma.registrarNegocio(negocio);
        plataforma.registrarConsumidor(consumidor);

        negocio.publicarPromocion("Descuento del 10%", "30-09-2023", "10%");
        consumidor.realizarReserva(negocio, "Producto A", 1);
    }
}

class Plataforma {
    private List<Negocio> negocios;
    private List<Consumidor> consumidores;

    public Plataforma() {
        this.negocios = new ArrayList<>();
        this.consumidores = new ArrayList<>();
    }

    public void registrarNegocio(Negocio negocio) {
        negocios.add(negocio);
    }

    public void registrarConsumidor(Consumidor consumidor) {
        consumidores.add(consumidor);
    }
}

class Negocio {
    private String nombre;
    private String direccion;
    private String horario;
    private String categoria;
    private List<Map<String, String>> promociones;
    private List<Map<String, String>> reservas;
    private List<String> productosServicios;
    private List<String> imagenes;

    public Negocio(String nombre, String direccion, String horario, String categoria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.categoria = categoria;
        this.promociones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.productosServicios = new ArrayList<>();
        this.imagenes = new ArrayList<>();
    }

    public void publicarPromocion(String descripcion, String validez, String descuento) {
        Map<String, String> promocion = new HashMap<>();
        promocion.put("descripcion", descripcion);
        promocion.put("validez", validez);
        promocion.put("descuento", descuento);
        promociones.add(promocion);
    }

    public void agregarProductoServicio(String productoServicio) {
        productosServicios.add(productoServicio);
    }

    public void realizarReserva(String consumidor, String productoServicio, int cantidad) {
        Map<String, String> reserva = new HashMap<>();
        reserva.put("consumidor", consumidor);
        reserva.put("productoServicio", productoServicio);
        reserva.put("cantidad", String.valueOf(cantidad));
        reservas.add(reserva);
    }

    // ... Otros métodos ...
}

class Consumidor {
    private String nombre;
    private String ubicacion;

    public Consumidor(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public void realizarReserva(Negocio negocio, String productoServicio, int cantidad) {
        negocio.realizarReserva(this.nombre, productoServicio, cantidad);
    }

    // ... Otros métodos ...
}

// Se pueden agregar más clases y funcionalidades según las características descritas previamente.
