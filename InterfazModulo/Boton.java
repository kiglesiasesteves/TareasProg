import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
    private int segundos;

    public Boton(String text, int tiempo) {
        super(text);
        this.segundos = tiempo;
    }


    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
}