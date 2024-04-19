import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUsuario extends JFrame {
    JPanel panel = new JPanel();
    JButton crearMision = new JButton("Crear Mision");
    JButton listarMisiones = new JButton("Listar Misiones");
    JButton visualizarEstado = new JButton("Visualizar Estado de la Misión");
    JButton simuladorDeTrayectoria = new JButton("Simulador De Trayectoria");
    GestionMisiones gestionMisiones = new GestionMisiones();

    public InterfazUsuario(){
        setTitle("Interfaz de Usuario");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(4, 4));

        crearMision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionMisiones.CrearMisiones(JOptionPane.showInputDialog("Nombre de la Mision"),
                        JOptionPane.showInputDialog("Fecha de Inicio"),
                        JOptionPane.showInputDialog("Objetivos"),
                        JOptionPane.showInputDialog("Estado de la Mision"),
                        JOptionPane.showInputDialog("Nombre de la nave"),
                JOptionPane.showInputDialog("Tripulantes de la nave"))
            ;}
        });

        listarMisiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionMisiones.ListarMisiones();
            }
        });

        visualizarEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String mision= JOptionPane.showInputDialog("Cual es la misión que quieres buscar?");
                gestionMisiones.buscarMision(mision);
            }
        });

        simuladorDeTrayectoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SimuladorTrayectoria();
            }
        });

        add(crearMision);
        add(listarMisiones);
        add(visualizarEstado);
        add(simuladorDeTrayectoria);
    }
}