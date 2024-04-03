import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraEvento extends JFrame {
    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JTextArea resultado;

    private JButton botonSuma;
    private JButton botonResta;

    public CalculadoraEvento() {
        super("Calculadora");
        setLayout(new FlowLayout());

        setDefVariables();

        FuncionSuma();

        FuncionResta();


        setDefResultado();
    }

    private void setDefResultado() {
        JLabel resultadoMostrar = new JLabel("Resultado: ");
        add(resultadoMostrar);
        resultado = new JTextArea(5, 20);
        add(new JScrollPane(resultado));
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setDefVariables() {
        JLabel primeravariable = new JLabel("Primer número:");
        add(primeravariable);
        campoNumero1 = new JTextField(10);
        add(campoNumero1);
        JLabel segundavariable = new JLabel("Segundo número:");
        add(segundavariable);
        campoNumero2 = new JTextField(10);
        add(campoNumero2);
    }



    private void FuncionResta() {

        botonResta = new JButton("RESTA");
        botonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero1 = Integer.parseInt(campoNumero1.getText());
                    int numero2 = Integer.parseInt(campoNumero2.getText());
                    resultado.append(numero1 + " - " + numero2 + " = " + (numero1 - numero2) + "\n");
                } catch (NumberFormatException ex) {
                    resultado.append("Invalid input\n");
                }
            }
        });
        add(botonResta);
    }

    private void FuncionSuma() {
        botonSuma = new JButton("SUMA");
        botonSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero1 = Integer.parseInt(campoNumero1.getText());
                    int numero2 = Integer.parseInt(campoNumero2.getText());
                    resultado.append(numero1 + " + " + numero2 + " = " + (numero1 + numero2) + "\n");
                } catch (NumberFormatException ex) {
                    resultado.append("Invalid input\n");
                }
            }
        });
        add(botonSuma);
    }
}
