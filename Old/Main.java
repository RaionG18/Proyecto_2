import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class PlataformaComercioLocal {

    private static Plataforma plataforma = new Plataforma();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarNegocio();
                    break;
                case 2:
                    registrarConsumidor();
                    break;
                case 3:
                    publicarPromocion();
                    break;
                case 4:
                    agregarProductoServicio();
                    break;
                case 5:
                    realizarReserva();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("---- Menú Principal ----");
        System.out.println("1. Registrar Negocio");
        System.out.println("2. Registrar Consumidor");
        System.out.println("3. Publicar Promoción");
        System.out.println("4. Agregar Producto/Servicio");
        System.out.println("5. Realizar Reserva");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarNegocio() {
        System.out.print("Nombre del negocio: ");
        String nombre = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Horario: ");
        String horario = scanner.nextLine();

        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        Negocio negocio = new Negocio(nombre, direccion, horario, categoria);
        plataforma.registrarNegocio(negocio);
        System.out.println("Negocio registrado con éxito.");
    }

    private static void registrarConsumidor() {
        System.out.print("Nombre del consumidor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        Consumidor consumidor = new Consumidor(nombre, ubicacion);
        plataforma.registrarConsumidor(consumidor);
        System.out.println("Consumidor registrado con éxito.");
    }

    private static void publicarPromocion() {
        // Aquí puedes agregar lógica para seleccionar un negocio específico si hay múltiples negocios registrados

        System.out.print("Descripción de la promoción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Validez (ejemplo: 30-09-2023): ");
        String validez = scanner.nextLine();

        System.out.print("Descuento (ejemplo: 10%): ");
        String descuento = scanner.nextLine();

        // Suponiendo que el negocio es el primero en la lista (puedes modificar esto)
        Negocio negocio = plataforma.negocios.get(0);
        negocio.publicarPromocion(descripcion, validez, descuento);
        System.out.println("Promoción publicada con éxito.");
    }

    private static void agregarProductoServicio() {
        // Aquí puedes agregar lógica para seleccionar un negocio específico si hay múltiples negocios registrados

        System.out.print("Nombre del producto/servicio: ");
        String productoServicio = scanner.nextLine();

        // Suponiendo que el negocio es el primero en la lista (puedes modificar esto)
        Negocio negocio = plataforma.negocios.get(0);
        negocio.agregarProductoServicio(productoServicio);
        System.out.println("Producto/Servicio agregado con éxito.");
    }

    private static void realizarReserva() {
        // Aquí puedes agregar lógica para seleccionar un negocio y consumidor específico si hay múltiples registrados

        System.out.print("Nombre del producto/servicio a reservar: ");
        String productoServicio = scanner.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Suponiendo que el negocio es el primero en la lista y el consumidor también es el primero (puedes modificar esto)
        Negocio negocio = plataforma.negocios.get(0);
        Consumidor consumidor = plataforma.consumidores.get(0);
        consumidor.realizarReserva(negocio, productoServicio, cantidad);
        System.out.println("Reserva realizada con éxito.");
    }
}

class Plataforma {
    public List<Negocio> negocios;
    public List<Consumidor> consumidores;

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
