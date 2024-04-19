import javax.swing.*;
import java.util.ArrayList;

public class GestionMisiones {

    ArrayList<Mision> misiones = new ArrayList<>();
    ArrayList<Nave> naves = new ArrayList<>();


    public void CrearMisiones(String nombreMision, String fechaInicio, String objetivos,String estado, String nombreNave, String tripulantesNave){
       Nave Nuevanave=new Nave(nombreNave,tripulantesNave);
        naves.add(Nuevanave);

        misiones.add(new Mision(nombreMision,Nuevanave, fechaInicio, objetivos,estado));
    }
    public void ListarMisiones() {
        for (int i = 0; i < misiones.size(); i++) {
            JOptionPane.showMessageDialog(null, "Nombre de la Misión: " + misiones.get(i).getNombreMision());
            JOptionPane.showMessageDialog(null, "Fecha de Inicio: " + misiones.get(i).getFechaInicio());
            JOptionPane.showMessageDialog(null, "Objetivos de la Misión: " + misiones.get(i).getObjetivos());
            JOptionPane.showMessageDialog(null, "Nave Espacial Utilizada: " + misiones.get(i).getNaveEspacial().nombre);
            JOptionPane.showMessageDialog(null, "Tripulantes: " + misiones.get(i).getNaveEspacial().tripulantes);
        }
            }

        public Mision buscarMision(String nombreMision) {
            for (Mision mision : misiones) {
                if (mision.getNombreMision().equals(nombreMision)) {
                    JOptionPane.showMessageDialog(null, "El estado de la mision es "+mision.getEstado());
                }
            }
            return null;
        }
    }

