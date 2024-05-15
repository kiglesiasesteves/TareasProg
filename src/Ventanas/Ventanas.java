package Ventanas;

import clase.personajes.*;
import combatiente.Combatiente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventanas {
    private JFrame frame;
    private JComboBox<String> comboPersonajes;
    private JComboBox<String> comboPersonajes2;
    private JTextField campoUsuario;
    private JButton botonCrear;
    private JButton botonLuchar;
    private Combatiente personaje;
    private Combatiente personaje2;

    public Ventanas() {
        frame = new JFrame("Creador de Personajes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);

        frame.setVisible(true);
        JLabel etiquetaPersonaje2 = new JLabel("Personaje 2");
        etiquetaPersonaje2.setBounds(10, 110, 80, 25);
        panel.add(etiquetaPersonaje2);

        comboPersonajes2 = new JComboBox<>(new String[]{"Miserable", "Prisionero", "Profeta", "Samurai", "Vagante","Astrologo","Bandido","Confesor","Guerrero","Heroe"});
        comboPersonajes2.setBounds(100, 110, 165, 25);
        panel.add(comboPersonajes2);

    }

    private void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel etiquetaUsuario = new JLabel("Usuario");
        etiquetaUsuario.setBounds(10, 20, 80, 25);
        panel.add(etiquetaUsuario);

        campoUsuario = new JTextField(20);
        campoUsuario.setBounds(100, 20, 165, 25);
        panel.add(campoUsuario);

        JLabel etiquetaPersonaje = new JLabel("Personaje");
        etiquetaPersonaje.setBounds(10, 50, 80, 25);
        panel.add(etiquetaPersonaje);

        comboPersonajes = new JComboBox<>(new String[]{"Miserable", "Prisionero", "Profeta", "Samurai", "Vagante","Astrologo","Bandido","Confesor","Guerrero","Heroe"});
        comboPersonajes.setBounds(100, 50, 165, 25);
        panel.add(comboPersonajes);

        botonCrear = new JButton("Crear");
        botonCrear.setBounds(10, 80, 80, 25);
        panel.add(botonCrear);

        botonLuchar = new JButton("Luchar");
        botonLuchar.setBounds(100, 80, 80, 25);
        panel.add(botonLuchar);

        botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = campoUsuario.getText();
                String tipoPersonaje = (String) comboPersonajes.getSelectedItem();
                // Crear personaje basado en el tipo y mostrarlo
                switch (tipoPersonaje) {
                    case "Miserable":
                        personaje = new Miserable();
                        break;
                    case "Prisionero":
                        personaje = new Prisionero();
                        break;
                    case "Profeta":
                        personaje = new Profeta();
                        break;
                    case "Samurai":
                        personaje = new Samurai();
                        break;
                    case "Vagante":
                        personaje = new Vagante();
                        break;
                    case "Bandido":
                        personaje = new Bandido();
                        break;
                    case "Astrologo":
                        personaje = new Astrologo();
                        break;
                    case "Confesor":
                        personaje = new Confesor();
                        break;
                    case "Guerrero":
                        personaje = new Guerrero();
                        break;
                    case "Heroe":
                        personaje = new Heroe();
                        break;
                }
                // Mostrar el personaje creado
                JOptionPane.showMessageDialog(frame,"Personaje creado:\n" + personaje.toString());

            }
        });

        botonLuchar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoPersonaje2 = (String) comboPersonajes2.getSelectedItem();
                switch (tipoPersonaje2) {
                    case "Miserable":
                        personaje2 = new Miserable();

                        break;
                    case "Prisionero":
                        personaje2 = new Prisionero();
                        break;
                    case "Profeta":
                        personaje2 = new Profeta();
                        break;
                    case "Samurai":
                        personaje2 = new Samurai();
                        break;
                    case "Vagante":
                        personaje2 = new Vagante();
                        break;
                    case "Bandido":
                        personaje2 = new Bandido();
                        break;
                    case "Astrologo":
                        personaje2 = new Astrologo();
                        break;
                    case "Confesor":
                        personaje2 = new Confesor();
                        break;
                    case "Guerrero":
                        personaje2 = new Guerrero();
                        break;
                    case "Heroe":
                        personaje2 = new Heroe();
                        break;
                }
                Combatiente ganador = personaje.luchar(personaje2);
                if(ganador==null){
                    JOptionPane.showMessageDialog(frame,"La lucha termino en empate.");
                }
                // Mostrar el resultado de la lucha
                JOptionPane.showMessageDialog(frame,"El ganador es: :" + ganador.getClass().getSimpleName());
            }
        });
    }
}