package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class DetalleServicio {
    private String codigo;
    private Equipos equipo;
    private Servicios servicio;
    private String falla;
    private Tecnico tecnico;
    private int horasTrabajo;
    private EstadoOrden estado;
    private ArrayList<RepuestosUtilizados> listaRepuestos = new ArrayList<>();

    public DetalleServicio(String codigo, Equipos equipo, Servicios servicio, String falla, Tecnico tecnico, int horasTrabajo) {
        this.codigo = codigo;
        this.equipo = equipo;
        this.servicio = servicio;
        this.falla = falla;
        this.tecnico = tecnico;
        this.horasTrabajo = horasTrabajo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public ArrayList<RepuestosUtilizados> getListaRepuestos() {
        return listaRepuestos;
    }


}
