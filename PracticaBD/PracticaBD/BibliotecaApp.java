import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BibliotecaApp extends JFrame {
    private JTextField txtTitulo, txtAutor, txtAnoPublicacion;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnConsultar;
    private JTextArea txtAreaResultados;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public BibliotecaApp() {
        setTitle("Sistema de Gestión de Biblioteca");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(4, 2));
        panelEntrada.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelEntrada.add(txtTitulo);
        panelEntrada.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelEntrada.add(txtAutor);
        panelEntrada.add(new JLabel("Año de Publicación:"));
        txtAnoPublicacion = new JTextField();
        panelEntrada.add(txtAnoPublicacion);

        btnAgregar = new JButton("Agregar Libro");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        panelEntrada.add(btnAgregar);

        add(panelEntrada, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnActualizar = new JButton("Actualizar Libro");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para actualizar un libro
            }
        });
        panelBotones.add(btnActualizar);

        btnEliminar = new JButton("Eliminar Libro");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar un libro
            }
        });
        panelBotones.add(btnEliminar);

        btnConsultar = new JButton("Consultar Libros");
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarLibros();
            }
        });
        panelBotones.add(btnConsultar);

        add(panelBotones, BorderLayout.CENTER);

        txtAreaResultados = new JTextArea();
        add(new JScrollPane(txtAreaResultados), BorderLayout.SOUTH);

        conectarBD();
    }

    private void conectarBD() {
        try {
            String url = "jdbc:postgresql://localhost:5432/Biblioteca";
            String user = "tu_usuario";
            String password = "tu_contraseña";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void agregarLibro() {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        int anoPublicacion = Integer.parseInt(txtAnoPublicacion.getText());
        boolean disponible = true;

        try {
            String query = "INSERT INTO Libros (Titulo, Autor, AnoPublicacion, Disponible) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, autor);
            preparedStatement.setInt(3, anoPublicacion);
            preparedStatement.setBoolean(4, disponible);
            preparedStatement.executeUpdate();
            txtAreaResultados.setText("Libro agregado correctamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            txtAreaResultados.setText("Error al agregar el libro.");
        }
    }

    private void consultarLibros() {
        try {
            String query = "SELECT * FROM Libros";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            txtAreaResultados.setText(""); // Limpiar el área de resultados

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String titulo = resultSet.getString("Titulo");
                String autor = resultSet.getString("Autor");
                int anoPublicacion = resultSet.getInt("AnoPublicacion");
                boolean disponible = resultSet.getBoolean("Disponible");

                txtAreaResultados.append("ID: " + id + ", Título: " + titulo + ", Autor: " + autor +
                        ", Año de Publicación: " + anoPublicacion + ", Disponible: " + disponible + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            txtAreaResultados.setText("Error al consultar los libros.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaApp().setVisible(true);
            }
        });
    }
}
