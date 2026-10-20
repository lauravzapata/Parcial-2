package co.edu.uniquindio.poo.model;

public class MantenimientoPreventivo extends Servicios{

    public MantenimientoPreventivo(String codigoServicio, String nombre, String descripcion, int tarifaBase) {
        super(codigoServicio, nombre, descripcion, tarifaBase);
    }


    //Instanceof: sirve para comprobar de que clase es un objeto
    @Override
    public double calcularCosto(Equipos equipo, int horas) {
        if(equipo instanceof ComputadorPortatil){
            return 60000;
        } else if (equipo instanceof ComputadorEscritorio) {
            return 70000;
        } else if (equipo instanceof Telefonos) {
            return 40000;
        }
        return 0;
    }
}
