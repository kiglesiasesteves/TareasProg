import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorColores extends JFrame {
    private JComboBox<String> listaColores;
    private JPanel panel;
    private final String[] colores = {"Rosa", "Verde", "Azul"};

    public SelectorColores(){
        super("Selector de Colores");
        setLayout(new BorderLayout());

        setListaColores();
        setPanel();

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setPanel() {
        JLabel tagPanel = new JLabel("Color seleccionado: ");
        add(tagPanel, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.WHITE);

        JPanel panelCentrado = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;
        panelCentrado.add(panel, gbc);

        add(panelCentrado, BorderLayout.CENTER);
    }

    private void setListaColores() {
        JLabel tagLista = new JLabel("Selecciona un color: ");
        add(tagLista, BorderLayout.SOUTH);

        listaColores = new JComboBox<>(colores);
        listaColores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarColor();
            }
        });

        add(listaColores, BorderLayout.SOUTH);
    }

    private void actualizarColor() {
        String colorSeleccionado = (String) listaColores.getSelectedItem();
        Color color = null;
        switch (colorSeleccionado) {
            case "Rosa":
                color = Color.PINK;
                break;
            case "Verde":
                color = new Color(Color.HSBtoRGB(0.3f, 0.3f, 0.9f));
                break;
            case "Azul":
                color = new Color(Color.HSBtoRGB(0.55f, 0.3f, 0.9f));
                break;
            case null:
                break;
            default:
                color = Color.WHITE;
        }
        panel.setBackground(color);
    }

    public static void main(String[] args) {
        new SelectorColores();
    }
}
