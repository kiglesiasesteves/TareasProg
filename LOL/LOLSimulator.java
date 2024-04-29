import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LOLSimulator extends JFrame {
    private JComboBox<String> championComboBox;
    private JComboBox<String> roleComboBox;
    private JButton addChampionButton;
    private JTextArea teamTextArea;
    private JButton simulateButton;
    private JTextArea resultTextArea;

    // Estructura de datos para almacenar información de los campeones
    private Map<String, Champion> champions;

    public LOLSimulator() {
        setTitle("League of Legends Simulator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar la estructura de datos de campeones
        champions = loadChampions();

        // Panel para la selección de campeones y roles
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout());

        championComboBox = new JComboBox<>(champions.keySet().toArray(new String[0]));
        roleComboBox = new JComboBox<>(new String[]{"Tanque", "Soporte", "Carry", "Asesino"});
        addChampionButton = new JButton("Agregar Campeón");
        addChampionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String championName = (String) championComboBox.getSelectedItem();
                String roleName = (String) roleComboBox.getSelectedItem();
                Champion champion = champions.get(championName);
                champion.setRole(roleName);
                teamTextArea.append(champion.getName() + " - " + champion.getRole() + "\n");
            }
        });

        selectionPanel.add(championComboBox);
        selectionPanel.add(roleComboBox);
        selectionPanel.add(addChampionButton);

        // Área de texto para mostrar el equipo
        teamTextArea = new JTextArea();
        teamTextArea.setEditable(false);

        // Panel para la simulación de enfrentamientos
        JPanel simulationPanel = new JPanel();
        simulationPanel.setLayout(new FlowLayout());

        simulateButton = new JButton("Simular Enfrentamiento");
        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulateMatch();
            }
        });
        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);
        simulationPanel.add(simulateButton);
        simulationPanel.add(new JScrollPane(resultTextArea));

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(selectionPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(teamTextArea), BorderLayout.CENTER);
        mainPanel.add(simulationPanel, BorderLayout.SOUTH);


        add(mainPanel);
    }

    // Función para cargar datos de campeones desde un archivo
    private Map<String, Champion> loadChampions() {
        Map<String, Champion> champions = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("champions.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int health = Integer.parseInt(parts[1]);
                int attackDamage = Integer.parseInt(parts[2]);
                // Agregar más atributos según sea necesario
                Champion champion = new Champion(name, health, attackDamage);
                champions.put(name, champion);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return champions;
    }

    // Función para simular un enfrentamiento entre dos equipos
    private void simulateMatch() {
        // Implementar la lógica de simulación aquí
        // Esta es solo una simulación de ejemplo
        StringBuilder result = new StringBuilder();
        result.append("Resultado de la simulación:\n");
        result.append("Equipo Azul vs Equipo Rojo\n");
        result.append("Ganador: Equipo Azul\n");
        // Mostrar el resultado en el área de texto
        resultTextArea.setText(result.toString());
    }

    // Función para guardar la configuración del equipo en un archivo
    private void saveTeamConfiguration(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(teamTextArea.getText());
            writer.close();
            JOptionPane.showMessageDialog(this, "Configuración del equipo guardada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la configuración del equipo.");
        }
    }

    // Función para cargar la configuración del equipo desde un archivo
    private void loadTeamConfiguration(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder teamConfiguration = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                teamConfiguration.append(line).append("\n");
            }
            teamTextArea.setText(teamConfiguration.toString());
            reader.close();
            JOptionPane.showMessageDialog(this, "Configuración del equipo cargada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar la configuración del equipo.");
        }
    }
}