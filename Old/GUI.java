import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ... [Tus clases de Usuario, Reseña, Plataforma, Controlador (con modificaciones)] ...

class VistaGUI {
    private JFrame frame;
    private JPanel panel;
    private JButton btnIniciarSesion, btnRegistrarse, btnBuscar, btnPromociones, btnSalir;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private Controlador controlador;

    public VistaGUI(Controlador controlador) {
        this.controlador = controlador;
        frame = new JFrame("Plataforma Comercio Local");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        txtUsuario = new JTextField(20);
        txtUsuario.setBounds(100, 20, 160, 25);
        panel.add(txtUsuario);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        txtContraseña = new JPasswordField(20);
        txtContraseña.setBounds(100, 50, 160, 25);
        panel.add(txtContraseña);

        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setBounds(10, 80, 150, 25);
        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.iniciarSesion(txtUsuario.getText(), new String(txtContraseña.getPassword()));
            }
        });
        panel.add(btnIniciarSesion);

        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(10, 110, 150, 25);
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.registrarse(txtUsuario.getText(), new String(txtContraseña.getPassword()));
            }
        });
        panel.add(btnRegistrarse);

        // Puedes agregar más botones aquí como btnBuscar, btnPromociones, etc.

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(10, 140, 80, 25);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btnSalir);
    }

    // ... [Otros métodos según se requieran, por ejemplo, para mostrar mensajes, etc.] ...
}

// Cambio en el Controlador para manejar la GUI
class Controlador {
    private VistaGUI vista;
    private Plataforma plataforma;

    public Controlador(VistaGUI vista, Plataforma plataforma) {
        this.vista = vista;
        this.plataforma = plataforma;
    }

    public void iniciarSesion(String usuario, String contraseña) {
        // Aquí añades lógica para iniciar sesión, por ahora solo imprime
        System.out.println("Iniciando sesión con " + usuario);
    }

    public void registrarse(String usuario, String contraseña) {
        // Lógica para registrarse
        Usuario user = new Usuario(usuario, contraseña);
        plataforma.registrarUsuario(user);
        System.out.println("Usuario registrado con éxito");
    }

    // ... [Otros métodos según se requieran] ...
}

public class GUI {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();
        VistaGUI vista = new VistaGUI(new Controlador(null, plataforma));
        Controlador controlador = new Controlador(vista, plataforma);
        vista.setVisible(true);  // Mostramos la ventana principal
    }
}
