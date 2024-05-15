package clase.personajes;

import atributo.Atributos;
import combatiente.Combatiente;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Samurai implements Atributos, Combatiente{
    @Override
    public void setAtributo(String nombre, int valor) {
            atributos.put(nombre,valor);
    }
    public Samurai(){
        Map<String,Integer> atributosMap = new HashMap<>();
        atributosMap.put("Vigor", 12);
        atributosMap.put("Mente", 11);
        atributosMap.put("Aguante", 13);
        atributosMap.put("Fuerza", 12);
        atributosMap.put("Destreza", 15);
        atributosMap.put("Inteligencia", 9);
        atributosMap.put("Fe", 8);
        atributosMap.put("Arcano", 8);

        setAtributos(atributosMap);
    }
    @Override
    public Combatiente luchar(Combatiente oponente) {
        if(!(oponente instanceof Atributos)){
            throw new IllegalArgumentException("El oponente no tiene atributos");
        }
        if(this.getClass().equals(oponente.getClass())){
            return null; // empate si los dos personajes son de la misma clase
        }
        int sumaMisAtributos = sumarAtributos();
        int sumaAtributosOponente = ((Atributos)oponente).sumarAtributos();

        return sumaMisAtributos > sumaAtributosOponente ? this : oponente;
    }
    public void guardar(String nombreArchivo) {
        try (PrintWriter out = new PrintWriter(nombreArchivo)) {
            for (Map.Entry<String, Integer> entry : atributos.entrySet()) {
                out.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo guardar el personaje: " + e.getMessage());
        }
    }
    public void cargar(String nombreArchivo) {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                String[] linea = scanner.nextLine().split(":");
                setAtributo(linea[0], Integer.parseInt(linea[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo cargar el personaje: " + e.getMessage());
        }
    }
    @Override
    public String toString() {
        return "Samurai";
    }
}
