package main.java.plataforma.vista;

import main.java.plataforma.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaGUI {
    private static JFrame frame;
    private JPanel panel;
    private JButton btnIniciarSesion, btnRegistrarse, btnSalir;
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

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(10, 140, 80, 25);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btnSalir);

    }

    /**
     * Devuelve el marco principal (JFrame) de la aplicación.
     *
     * @return el objeto JFrame principal de la aplicación.
     */
    public static JFrame getFrame() {
        return frame;
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
