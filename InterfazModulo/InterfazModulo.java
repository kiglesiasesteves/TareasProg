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

        JButton botonPlay = new JButton("Play");
        botonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        panelControles.add(botonPlay);

        JButton botonPause = new JButton("Pause");
        botonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        panelControles.add(botonPause);

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
        for (int i = 1; i <= 9; i++) {
            panelNumerico.add(new JButton(String.valueOf(i)));
        }
        add(panelNumerico, BorderLayout.CENTER);

        progressBar = new JProgressBar();
        progressBar.setMaximum(100);

        add(progressBar, BorderLayout.NORTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progresoActual += 10;
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

    public static void main(String[] args) {
        new InterfazModulo();
    }
}
