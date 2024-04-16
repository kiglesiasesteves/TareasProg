import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Tabla extends JFrame {
    JTextField Colocarnome = new JTextField(20);
    JTextField Colocarapelido = new JTextField(20);
    JComboBox curso = new JComboBox(new String[]{"DAM", "DAW", "ASIR"});
    JButton anhadirTabla = new JButton("Agregar a Taboa");

    // Crear el modelo de la tabla
    DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Apellido", "Curso"}, 0);
    // Crear la tabla
    JTable tabla = new JTable(modeloTabla);

    public Tabla() {
        setTitle("Tabla");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridBagLayout());
        adicionar();

        // Agregar un ActionListener al botón
        anhadirTabla.addActionListener(e -> {
            // Recuperar los datos de los campos de texto y del JComboBox
            String nombre = Colocarnome.getText();
            String apellido = Colocarapelido.getText();
            String cursoSeleccionado = (String) curso.getSelectedItem();

            // Agregar una nueva fila al modelo de la tabla
            modeloTabla.addRow(new Object[]{nombre, apellido, cursoSeleccionado});
        });

        // Agregar la tabla al JFrame
        add(new JScrollPane(tabla), new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
    }

    public void adicionar(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nome = new JLabel("Nome");
        panel.add(nome);
        panel.add(Colocarnome);

        JLabel apelido = new JLabel("Apelido");
        panel.add(apelido);
        panel.add(Colocarapelido);

        panel.add(curso);

        add(panel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

        add(anhadirTabla, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    }

    public static void main(String[] args) {
        new Tabla();
    }
}