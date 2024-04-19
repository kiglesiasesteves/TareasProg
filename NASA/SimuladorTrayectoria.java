import javax.swing.*;
import java.awt.*;

public class SimuladorTrayectoria extends JFrame {

    public SimuladorTrayectoria() {
        setTitle("Simulador de Trayectoria de Misión Espacial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Pedir al usuario las coordenadas de la trayectoria
        int xInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la coordenada X del punto de inicio:"));
        int yInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la coordenada Y del punto de inicio:"));
        int xFin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la coordenada X del punto de llegada:"));
        int yFin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la coordenada Y del punto de llegada:"));

        // Crear el panel para la trayectoria
        JPanel trajectoryPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la trayectoria con las coordenadas proporcionadas por el usuario
                g.drawLine(xInicio, yInicio, xFin, yFin);
            }
        };

        getContentPane().add(trajectoryPanel, BorderLayout.CENTER);

        setVisible(true);
    }


}

