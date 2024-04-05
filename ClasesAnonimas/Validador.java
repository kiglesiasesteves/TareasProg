import javax.swing.*;

public class Validador {

    public void validar() {
        Valid validador = new Valid() {
            @Override
            public boolean par(int numero) {
                return numero % 2 == 0;
            }
        };

        int numero = 0;
        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No has introducido un número válido");
                continue;
            }

            if (numero != 0) {
                if (validador.par(numero)) {
                    JOptionPane.showMessageDialog(null, "El número " + numero + " es par");
                } else {
                    JOptionPane.showMessageDialog(null, "El número " + numero + " es impar");
                }
            }

        } while (numero != 0);
    }
}
