package co.edu.uniquindio.poo.model;

public class Telefonos extends Equipos {
    private String sistemaOperativo;
    private String almacenamientoTelefono;
    private String capacidadBateria;
    private boolean compatible5G;

    public Telefonos(String codigo, String numeroSerie, String marca, String anoFabricacion, String modelo, String descripcion, String sistemaOperativo, String almacenamiento, String capacidadBateria, boolean compatible5G) {
        super(codigo, numeroSerie, marca, anoFabricacion, modelo, descripcion);
        this.sistemaOperativo = sistemaOperativo;
        this.almacenamientoTelefono = almacenamiento;
        this.capacidadBateria = capacidadBateria;
        this.compatible5G = compatible5G;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getAlmacenamientoTelefono() {
        return almacenamientoTelefono;
    }

    public void setAlmacenamientoTelefono(String almacenamientoTelefono) {
        this.almacenamientoTelefono = almacenamientoTelefono;
    }

    public String getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(String capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }

    public boolean isCompatible5G() {
        return compatible5G;
    }

    public void setCompatible5G(boolean compatible5G) {
        this.compatible5G = compatible5G;
    }
}
