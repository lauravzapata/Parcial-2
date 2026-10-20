package co.edu.uniquindio.poo.model;

public class Repuestos {
    private String codigoUnico;
    private String nombreRepuesto;
    private String descripcionRepuesto;
    private int precioUnidad;
    private int cantidadDisponible;
    private String categoriaCompatibilidad;

    public Repuestos(String codigoUnico, String nombreRepuesto, String descripcionRepuesto, int precioUnidad, int cantidadDisponible, String categoriaCompatibilidad) {
        this.codigoUnico = codigoUnico;
        this.nombreRepuesto = nombreRepuesto;
        this.descripcionRepuesto = descripcionRepuesto;
        this.precioUnidad = precioUnidad;
        this.cantidadDisponible = cantidadDisponible;
        this.categoriaCompatibilidad = categoriaCompatibilidad;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getDescripcionRepuesto() {
        return descripcionRepuesto;
    }

    public void setDescripcionRepuesto(String descripcionRepuesto) {
        this.descripcionRepuesto = descripcionRepuesto;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getCategoriaCompatibilidad() {
        return categoriaCompatibilidad;
    }

    public void setCategoriaCompatibilidad(String categoriaCompatibilidad) {
        this.categoriaCompatibilidad = categoriaCompatibilidad;
    }

    public boolean cantidadSolicitada(int cantidad){
        return cantidad>0 && cantidad<= cantidadDisponible;
    }

}
