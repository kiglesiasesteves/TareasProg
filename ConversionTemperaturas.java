import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversionTemperaturas extends JFrame {
    private JTextField celsiusField;
    private JTextField fahrenheitField;

    public ConversionTemperaturas() {
        super("Conversor de Temperaturas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los componentes de la interfaz
        JLabel celsiusLabel = new JLabel("Celsius:");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");

        celsiusField = new JTextField(10);
        fahrenheitField = new JTextField(10);
        fahrenheitField.setEditable(true);

        JButton celsiusToFahrenheitButton = new JButton("Celsius a Fahrenheit");
        JButton fahrenheitToCelsiusButton = new JButton("Fahrenheit a Celsius");

        // Agregar los componentes al panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(celsiusLabel);
        panel.add(celsiusField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitField);
        panel.add(celsiusToFahrenheitButton);
        panel.add(fahrenheitToCelsiusButton);

        // Manejo de eventos para el botón "Celsius a Fahrenheit"
        celsiusToFahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirCelsiusAFahrenheit();
            }
        });

        // Manejo de eventos para el botón "Fahrenheit a Celsius"
        fahrenheitToCelsiusButton.addActionListener(new FahrenheitToCelsiusListener());

        // Agregar el panel al frame
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    // Método para convertir de Celsius a Fahrenheit
    private void convertirCelsiusAFahrenheit() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un número válido para la temperatura en Celsius.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clase interna para manejar el evento del botón "Fahrenheit a Celsius"
    private class FahrenheitToCelsiusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                double celsius = (fahrenheit - 32) * 5 / 9;
                celsiusField.setText(String.format("%.2f", celsius));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ConversionTemperaturas.this, "Por favor ingresa un número válido para la temperatura en Fahrenheit.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
