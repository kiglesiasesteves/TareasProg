public class Nave {
    String nombre;
    String tripulantes;

    public Nave(String nombre, String tripulantes) {
        this.nombre = nombre;
        this.tripulantes = tripulantes;
    }

    public Nave(String nombreDeLaNave, String[] tripulantes) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(String tripulantes) {
        this.tripulantes = tripulantes;
    }
}
