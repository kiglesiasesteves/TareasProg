import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Champion annie = new Champion("Annie", 500, 50);                LOLSimulator simulator = new LOLSimulator();
                simulator.setVisible(true);
            }
        });
    }
}