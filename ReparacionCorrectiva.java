package co.edu.uniquindio.poo.model;

public class ReparacionCorrectiva extends Servicios{
    private int horasTrabajo;

    public ReparacionCorrectiva(String codigoServicio, String nombre, String descripcion, int tarifaBase, int horasTrabajo) {
        super(codigoServicio, nombre, descripcion, tarifaBase);
        this.horasTrabajo = horasTrabajo;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }


    @Override
    public double calcularCosto(Equipos equipo, int horas) {
        double costo = getTarifaBase() + (horas * 45000);
        return costo;
    }
}
