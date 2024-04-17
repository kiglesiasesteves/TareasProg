import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Tabla {
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JComboBox<String> cajaCursos;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    public Tabla() {
        JFrame frame = new JFrame("Interfaz Tabla"); // Crear una ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la ventana
        frame.setSize(550, 550); // Tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana al ejecutar

        JPanel panel = new JPanel(); // Crear un panel
        frame.add(panel); // Añadir el panel a la ventana

        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Crear un panel con layout FlowLayout alineado a la izquierda
        JLabel etiquetaNombre = new JLabel("Nombre:"); // Crear una etiqueta
        campoNombre = new JTextField(10); // Crear un campo de texto
        panelNombre.add(etiquetaNombre); // Añadir la etiqueta al panel
        panelNombre.add(campoNombre); // Añadir el campo de texto al panel



        String[] cursos = {"dam1", "dam2", "asir", "daw"}; // Crear un array de cursos
        cajaCursos = new JComboBox<>(cursos); // Crear un JComboBox con los cursos
        cajaCursos.setPreferredSize(new Dimension(120, 20)); // Establecer el tamaño del JComboBox
        panelNombre.add(cajaCursos); // Añadir el JComboBox al panel
        panel.add(panelNombre); // Añadir el panel al panel principal

        JPanel panelApellido = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Crear un panel con layout FlowLayout alineado a la izquierda
        JLabel etiquetaApellido = new JLabel("Apellido:"); // Crear una etiqueta
        campoApellido = new JTextField(10); // Crear un campo de texto
        panelApellido.add(etiquetaApellido); // Añadir la etiqueta al panel
        panelApellido.add(campoApellido); // Añadir el campo de texto al panel

        JButton botonAgregar = new JButton("Añadir a tabla"); // Crear un botón
        botonAgregar.addActionListener(e -> { // Añadir un listener al botón
            String nombre = campoNombre.getText(); // Obtener el texto del campo de texto
            String apellido = campoApellido.getText(); // Obtener el texto del campo de texto
            String curso = (String) cajaCursos.getSelectedItem(); // Obtener el curso seleccionado
            modeloTabla.addRow(new Object[]{nombre, apellido, curso}); // Añadir una fila a la tabla con los datos
        });
        panelApellido.add(botonAgregar); // Añadir el botón al panel
        panel.add(panelApellido); // Añadir el panel al panel principal

        modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Apellido", "Curso"}, 0); // Crear un modelo de tabla
        tabla = new JTable(modeloTabla); // Crear una tabla con el modelo
        JScrollPane scrollPane = new JScrollPane(tabla); // Crear un JScrollPane con la tabla
        panel.add(scrollPane); // Añadir el JScrollPane al panel

        frame.setVisible(true); // Hacer visible la ventana
    }
}