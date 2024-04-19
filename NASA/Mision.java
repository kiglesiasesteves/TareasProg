public class Mision {
    String nombreMision;
    String fechaInicio;
    String objetivos;
    String estado;
Nave naveEspacial;

    public Mision(String nombreMision, Nave naveEspacial, String estado, String objetivos, String fechaInicio) {
        this.nombreMision = nombreMision;
        this.naveEspacial = naveEspacial;
        this.estado = estado;
        this.objetivos = objetivos;
        this.fechaInicio = fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreMision() {
        return nombreMision;
    }

    public void setNombreMision(String nombreMision) {
        this.nombreMision = nombreMision;
    }

    public Nave getNaveEspacial() {
        return naveEspacial;
    }

    public void setNaveEspacial(Nave naveEspacial) {
        this.naveEspacial = naveEspacial;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
