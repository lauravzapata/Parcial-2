package co.edu.uniquindio.poo.model;

public class RepuestosUtilizados {
    private Repuestos repuesto;
    private int cantidad;
    private int precioUnidadAplicado;

    public RepuestosUtilizados(Repuestos repuesto, int cantidad, int precioUnidadAplicado) {
        this.repuesto = repuesto;
        this.cantidad = cantidad;
        this.precioUnidadAplicado = precioUnidadAplicado;
    }

    public Repuestos getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuestos repuesto) {
        this.repuesto = repuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnidadAplicado() {
        return precioUnidadAplicado;
    }

    public void setPrecioUnidadAplicado(int precioUnidadAplicado) {
        this.precioUnidadAplicado = precioUnidadAplicado;
    }


}
