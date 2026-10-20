package co.edu.uniquindio.poo.model;

public class Diagnostico extends Servicios{

    public Diagnostico(String codigoServicio, String nombre, String descripcion, int tarifaBase) {
        super(codigoServicio, nombre, descripcion, tarifaBase);
    }

    @Override
    public double calcularCosto(Equipos equipo, int horas) {
        return 35000;
    }
}
