import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MinecraftResourceManager extends JFrame {
    private Map<String, Integer> materials = new HashMap<>();
    private JTextField quantityTextField;

    public MinecraftResourceManager() {
        // Configuración básica de la ventana
        setTitle("Gestor de Recursos de Minecraft");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear componentes de la interfaz gráfica
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Selecciona un material:");
        JComboBox<String> materialsComboBox = new JComboBox<>(new String[]{"Piedra", "Madera", "Hierro"});
        quantityTextField = new JTextField(10);
        JButton addButton = new JButton("Agregar");
        JTextArea outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);

        // Agregar componentes al panel
        panel.add(label);
        panel.add(materialsComboBox);
        panel.add(new JLabel("Cantidad:"));
        panel.add(quantityTextField);
        panel.add(addButton);
        panel.add(new JScrollPane(outputArea));

        // Agregar el panel a la ventana
        add(panel);

        // Acción del botón "Agregar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String material = (String) materialsComboBox.getSelectedItem();
                int quantity = Integer.parseInt(quantityTextField.getText());
                if (materials.containsKey(material)) {
                    materials.put(material, materials.get(material) + quantity);
                } else {
                    materials.put(material, quantity);
                }
                updateOutput(outputArea);
            }
        });

        // Hacer visible la ventana
        setVisible(true);
    }

    private void updateOutput(JTextArea outputArea) {
        outputArea.setText("");
        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            outputArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MinecraftResourceManager::new);
    }
}
