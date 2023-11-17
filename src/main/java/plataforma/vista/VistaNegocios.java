package main.java.plataforma.vista;
import javax.swing.*;
import java.awt.*;

public class VistaNegocios extends JPanel {
    public VistaNegocios() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Aquí puedes agregar los componentes de esta vista, por ejemplo, una lista de negocios
        JLabel titulo = new JLabel("Negocios Sugeridos");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo);

        // String[] negocios = {"Negocio 1", "Negocio 2", "Negocio 3"};
        // JList listaNegocios = new JList(negocios);
        // this.add(listaNegocios);
    }

}
