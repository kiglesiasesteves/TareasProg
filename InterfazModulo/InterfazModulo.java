import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazModulo extends JFrame {
    private JProgressBar progressBar;
    private Timer timer;
    private int progresoActual;

    public InterfazModulo() {
        setLayout(new BorderLayout());

        JPanel panelControles = new JPanel();
        panelControles.setLayout(new BoxLayout(panelControles, BoxLayout.X_AXIS));

        setPlayBoton(panelControles);

        setPauseBoton(panelControles);

        JButton botonStop = new JButton("Stop");
        botonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                progresoActual = 0;
                progressBar.setValue(progresoActual);
            }
        });
        panelControles.add(botonStop);

        add(panelControles, BorderLayout.SOUTH);

        JPanel panelNumerico = new JPanel();
        panelNumerico.setLayout(new GridLayout(3, 3));
        Boton boton1 = new Boton("HALO - Beyoncé", 90);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTiempo(boton1.getSegundos());
            }
        });
        panelNumerico.add(boton1);

        Boton boton2 = new Boton("El fin del Mundo - La La Love You", 90);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTiempo(boton2.getSegundos());
            }
        });
        panelNumerico.add(boton2);

        add(panelNumerico, BorderLayout.CENTER);

        progressBar = new JProgressBar();
        progressBar.setMaximum(100);

        add(progressBar, BorderLayout.NORTH);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progresoActual += 1;
                if (progresoActual > 100) {
                    progresoActual = 100;
                    timer.stop();
                }
                progressBar.setValue(progresoActual);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private void setTiempo(int segundos) {
        timer.stop();
        progresoActual = 0;
        progressBar.setValue(progresoActual);
        timer = new Timer(segundos * 10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progresoActual += 1;
                if (progresoActual > 100) {
                    progresoActual = 100;
                    timer.stop();
                }
                progressBar.setValue(progresoActual);
            }
        });
        timer.start();
    }

    private void setPauseBoton(JPanel panelControles) {
        JButton botonPause = new JButton("Pause");
        botonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        panelControles.add(botonPause);
    }

    private void setPlayBoton(JPanel panelControles) {
        JButton botonPlay = new JButton("Play");
        botonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        panelControles.add(botonPlay);
    }

    public static void main(String[] args) {
        new InterfazModulo();
    }
}