import Ventanas.Ventanas;

import clase.personajes.Astrologo;
public class Main {
    public static void main(String[] args) {
        new Ventanas();
        Astrologo astrologo = new Astrologo();
        astrologo.guardar("astrologo.txt");

        Astrologo astrologoCargado = new Astrologo();
        astrologoCargado.cargar("astrologo.txt");
    }
}