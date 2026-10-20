package co.edu.uniquindio.poo.model;

public class ComputadorPortatil extends Equipos {
    private String tamanoPantalla;
    private String capacidadMemoria;
    private String capacidadAlmacenamiento;
    private boolean bateriaExtraible;

    public ComputadorPortatil(String codigo, String numeroSerie, String marca, String anoFabricacion, String modelo, String descripcion, String tamanoPantalla, String capacidadMemoria, boolean bateriaExtraible, String capacidadAlmacenamiento) {
        super(codigo, numeroSerie, marca, anoFabricacion, modelo, descripcion);
        this.tamanoPantalla = tamanoPantalla;
        this.capacidadMemoria = capacidadMemoria;
        this.bateriaExtraible = bateriaExtraible;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public String getTamanoPantalla() {
        return tamanoPantalla;
    }

    public void setTamanoPantalla(String tamanoPantalla) {
        this.tamanoPantalla = tamanoPantalla;
    }

    public String getCapacidadMemoria() {
        return capacidadMemoria;
    }

    public void setCapacidadMemoria(String capacidadMemoria) {
        this.capacidadMemoria = capacidadMemoria;
    }

    public String getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(String capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public boolean isBateriaExtraible() {
        return bateriaExtraible;
    }

    public void setBateriaExtraible(boolean bateriaExtraible) {
        this.bateriaExtraible = bateriaExtraible;
    }

}
