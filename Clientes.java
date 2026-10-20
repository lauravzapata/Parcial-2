package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Clientes {
    private String nombreCompleto;
    private String telefono;
    private String identificacion;
    private String correo;
    private String direccion;

    private ArrayList<Equipos> listaEquipos = new ArrayList<>();


    public Clientes(String nombreCompleto, String telefono, String identificacion, String correo, String direccion) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", equipos=" + listaEquipos +
                '}';
    }
    public boolean registrarEquipo(Equipos equipo) {
        for (Equipos equipoRegistrado : listaEquipos) {
            if (equipoRegistrado.getCodigo().equals(equipo.getCodigo())) {
                return false;
            }
        }
        listaEquipos.add(equipo);
        return true;
    }
    public Equipos buscarEquipo(String codigo) {
        for (Equipos equipo : listaEquipos) {
            if (equipo.getCodigo().equalsIgnoreCase(codigo)) {
                return equipo;
            }
        }
        return null;
    }
    public boolean actualizarEquipo(String codigo, Equipos equipoNuevo) {
        Equipos equipoActual = buscarEquipo(codigo);
        if (equipoActual == null) {
            return false;
        }
        equipoActual.setMarca(equipoNuevo.getMarca());
        equipoActual.setModelo(equipoNuevo.getModelo());
        equipoActual.setAnoFabricacion(equipoNuevo.getAnoFabricacion());
        equipoActual.setDescripcion(equipoNuevo.getDescripcion());

        return true;
    }
    public boolean eliminarEquipo(String codigo) {
        Equipos equipo = buscarEquipo(codigo);

        if (equipo == null) {
            return false;
        }
        listaEquipos.remove(equipo);
        return true;
    }
}





