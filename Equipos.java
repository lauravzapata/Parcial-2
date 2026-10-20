package co.edu.uniquindio.poo.model;

public class Equipos {
    private final String codigo;
    private final String numeroSerie;
    private String marca;
    private String modelo;
    private String anoFabricacion;
    private String descripcion;

    public Equipos(String codigo, String numeroSerie, String marca, String anoFabricacion, String modelo, String descripcion) {
        this.codigo = codigo;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.anoFabricacion = anoFabricacion;
        this.modelo = modelo;
        this.descripcion = descripcion;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(String anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
