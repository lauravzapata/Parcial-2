package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdenServicio  {
    private final String codigoUnico;
    private LocalDate fechaCreacion;
    private Clientes clienteAsociado;
    private String observaciones;


    private EstadoOrden estado;
    private ArrayList<DetalleServicio> listaDetalles = new ArrayList<>();

    public OrdenServicio(String codigoUnico, Clientes clienteAsociado, String observaciones) {
        this.codigoUnico = codigoUnico;
        this.fechaCreacion = LocalDate.now();
        this.clienteAsociado = clienteAsociado;
        this.observaciones = observaciones;
        this.estado = EstadoOrden.ABIERTA;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public Clientes getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Clientes clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public ArrayList<DetalleServicio> getListaDetalles() {
        return listaDetalles;
    }




}
