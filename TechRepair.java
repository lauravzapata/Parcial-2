package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class TechRepair {
    private String nombre;
    private String direccion;
    private String nit;


    public final ArrayList<Clientes> listaClientes = new ArrayList<>();
    public final ArrayList<Equipos> listaEquipos = new ArrayList<>();
    private ArrayList<Repuestos> listaRepuestos = new ArrayList<>();
    private ArrayList<OrdenServicio> listaOrdenes = new ArrayList<>();
    private ArrayList<Servicios> listaServicios = new ArrayList<>();
    private ArrayList<Tecnico> listaTecnicos = new ArrayList<>();


    public TechRepair(String nombre, String direccion, String nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {

        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {

        return nit;
    }

    public void setNit(String nit) {

        this.nit = nit;
    }

    public ArrayList<Clientes> getListaClientes() {

        return listaClientes;
    }

    public ArrayList<Equipos> getListaEquipos() {
        return listaEquipos;
    }

    public ArrayList<Repuestos> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(ArrayList<Repuestos> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    public ArrayList<OrdenServicio> getListaOrdenes() {
        return listaOrdenes;
    }

    public void setListaOrdenes(ArrayList<OrdenServicio> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    public ArrayList<Servicios> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicios> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public ArrayList<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    //CRUD cliente
    //1
    public Clientes buscarCliente(String identificacion) {
        for (Clientes cliente : listaClientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                return cliente;
            }
        }
        return null;
    }

    public String registrarCliente(Clientes cliente) {
        Clientes clienteEncontrado = buscarCliente(cliente.getIdentificacion());
        if (clienteEncontrado == null) {
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        } else {
            return "No se puede registrar, ya existe un cliente con esa información.";
        }
    }

    public String actualizarCliente(String identificacion, String nombreCompleto, String telefono, String correo, String direccion) {
        Clientes cliente = buscarCliente(identificacion);
        if (cliente == null) {
            return "No existe un cliente con esta identificacion";
        }
        if (nombreCompleto.equals("")) {
            return "El nombre no puede estar vacio";
        }
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
        cliente.setDireccion(direccion);
        return "El cliente fue actualizado exitosamente";
    }

    public boolean eliminarCliente(String identificacion) {
        Clientes cliente = buscarCliente(identificacion);
        if (cliente == null) {
            return false;
        }
        return listaClientes.remove(cliente);
    }

    //CRUD repuesto
    public boolean registrarRepuesto(Repuestos repuesto) {
        for (Repuestos repuestos : listaRepuestos) {
            if (repuestos.getCodigoUnico().equalsIgnoreCase(repuesto.getCodigoUnico())) {
                return false;
            }
        }
        listaRepuestos.add(repuesto);
        return true;
    }

    public Repuestos buscarRepuesto(String codigo) {
        for (Repuestos repuesto : listaRepuestos) {
            if (repuesto.getCodigoUnico().equalsIgnoreCase(codigo)) {
                return repuesto;
            }
        }

        return null;
    }

    public boolean editarRepuesto(String codigo, Repuestos repuestoNuevo) {
        Repuestos repuestoActual = buscarRepuesto(codigo);
        if (repuestoActual == null) {
            return false;
        }
        if (!codigo.equalsIgnoreCase(repuestoNuevo.getCodigoUnico())
                && buscarRepuesto(repuestoNuevo.getCodigoUnico()) != null) {
            return false;
        }
        repuestoActual.setNombreRepuesto(repuestoNuevo.getNombreRepuesto());
        repuestoActual.setPrecioUnidad(repuestoNuevo.getPrecioUnidad());
        repuestoActual.setCantidadDisponible(repuestoNuevo.getCantidadDisponible());
        return true;
    }

    public boolean eliminarRepuesto(String codigo) {
        Repuestos repuesto = buscarRepuesto(codigo);
        if (repuesto == null) {
            return false;
        }
        listaRepuestos.remove(repuesto);
        return true;
    }

    public Tecnico buscarTecnico(String documento) {
        for (Tecnico tecnico : listaTecnicos) {
            if (tecnico.getDocumento().equalsIgnoreCase(documento)) {
                return tecnico;
            }
        }
        return null;
    }
    public boolean registrarTecnico(Tecnico tecnico) {
        for (Tecnico tecnicoRegistrado : listaTecnicos) {
            if (tecnicoRegistrado.getDocumento().equals(tecnico.getDocumento())) {
                return false;
            }
        }
        listaTecnicos.add(tecnico);
        return true;
    }
    public boolean actualizarTecnico(String documento, Tecnico tecnicoNuevo) {
        Tecnico tecnicoActual = buscarTecnico(documento);
        if (tecnicoActual == null) {
            return false;
        }
        tecnicoActual.setNombre(tecnicoNuevo.getNombre());
        tecnicoActual.setEspecialidad(tecnicoNuevo.getEspecialidad());
        tecnicoActual.setEstadoLaboral(tecnicoNuevo.getEstadoLaboral());

        return true;
    }
    public boolean eliminarTecnico(String documento) {
        Tecnico tecnico = buscarTecnico(documento);
        if (tecnico == null) {
            return false;
        }
        listaTecnicos.remove(tecnico);
        return true;
    }


    public boolean crearOrdenServicio(String codigoOrden, String identificacionCliente, String observaciones) {
        Clientes cliente = buscarCliente(identificacionCliente);
        if (cliente == null) {
            return false;
        }
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getCodigoUnico().equals(codigoOrden)) {
                return false;
            }
        }
        OrdenServicio orden = new OrdenServicio(codigoOrden, cliente, observaciones);
        listaOrdenes.add(orden);
        return true;
    }


    public boolean agregarDetalleOrden(String codigoOrden, DetalleServicio detalle) {
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getCodigoUnico().equals(codigoOrden)) {
                if (orden.getEstado() != EstadoOrden.ABIERTA) {
                    return false;
                }
                for (DetalleServicio detalleExistente : orden.getListaDetalles()) {
                    if (detalleExistente.getCodigo().equals(detalle.getCodigo())) {
                        return false;
                    }
                }
                orden.getListaDetalles().add(detalle);
                return true;
            }
        }
        return false;
    }

    public boolean registrarRepuestoUtilizado(String codigoOrden, String codigoDetalle, String codigoRepuesto, int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getCodigoUnico().equals(codigoOrden)) {
                if (orden.getEstado() != EstadoOrden.ABIERTA) {
                    return false;
                }
                for (DetalleServicio detalle : orden.getListaDetalles()) {
                    if (detalle.getCodigo().equals(codigoDetalle)) {
                        for (Repuestos repuesto : listaRepuestos) {
                            if (repuesto.getCodigoUnico().equals(codigoRepuesto)) {
                                if (repuesto.getCantidadDisponible() < cantidad) {
                                    return false;
                                }
                                RepuestosUtilizados utilizado = new RepuestosUtilizados(repuesto, cantidad, repuesto.getPrecioUnidad());
                                detalle.getListaRepuestos().add(utilizado);
                                repuesto.setCantidadDisponible(repuesto.getCantidadDisponible() - cantidad);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public double calcularValorDetalle(DetalleServicio detalle) {
        double costo = detalle.getServicio().calcularCosto(detalle.getEquipo(), detalle.getHorasTrabajo());
        for (RepuestosUtilizados repuesto : detalle.getListaRepuestos()) {
            costo += repuesto.getCantidad() * repuesto.getPrecioUnidadAplicado();
        }
        return costo;
    }

    public int calcularValorTotalOrden(String codigoOrden) {
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getCodigoUnico().equals(codigoOrden)) {
                int total = 0;
                for (DetalleServicio detalle : orden.getListaDetalles()) {
                    total += calcularValorDetalle(detalle);
                }
                return total;
            }
        }
        return 0;
    }

    public boolean actualizarEstadoDetalle(String codigoOrden, String codigoDetalle, EstadoOrden nuevoEstado) {
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getCodigoUnico().equals(codigoOrden)) {
                for (DetalleServicio detalle : orden.getListaDetalles()) {
                    if (detalle.getCodigo().equals(codigoDetalle)) {
                        detalle.setEstado(nuevoEstado);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean finalizarOrden(String codigoOrden) {
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getCodigoUnico().equals(codigoOrden)) {
                if (orden.getListaDetalles().isEmpty()) {
                    return false;
                }
                for (DetalleServicio detalle : orden.getListaDetalles()) {
                    if (detalle.getEstado() != EstadoOrden.FINALIZADA) {
                        return false;
                    }
                }
                orden.setEstado(EstadoOrden.FINALIZADA);
                return true;
            }
        }
        return false;
    }

    public ArrayList<DetalleServicio> consultarTrabajosTecnico(String documentoTecnico) {
        ArrayList<DetalleServicio> trabajos = new ArrayList<>();
        for (OrdenServicio orden : listaOrdenes) {
            for (DetalleServicio detalle : orden.getListaDetalles()) {
                if (detalle.getTecnico() != null &&
                        detalle.getTecnico().getDocumento()
                                .equals(documentoTecnico)) {

                    trabajos.add(detalle);
                }
            }
        }
        return trabajos;
    }

    public ArrayList<Repuestos> consultarInventarioCritico() {
        ArrayList<Repuestos> repuestosCriticos = new ArrayList<>();
        for (Repuestos repuesto : listaRepuestos) {
            if (repuesto.getCantidadDisponible() < 5) {
                repuestosCriticos.add(repuesto);
            }
        }
        return repuestosCriticos;
    }

    public ArrayList<OrdenServicio> consultarOrdenesCliente(String identificacionCliente) {
        ArrayList<OrdenServicio> ordenesCliente = new ArrayList<>();
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getClienteAsociado().getIdentificacion().equals(identificacionCliente)) {
                ordenesCliente.add(orden);
            }
        }
        return ordenesCliente;
    }

    public boolean asignarTecnico(String codigoOrden, String codigoDetalle, String documentoTecnico) {
        Tecnico tecnicoEncontrado = null;
        for (Tecnico t : listaTecnicos) {
            if (t.getDocumento().equals(documentoTecnico)) {
                tecnicoEncontrado = t;
                break;
            }
        }

        if (tecnicoEncontrado != null) {
            for (OrdenServicio orden : listaOrdenes) {
                if (orden.getCodigoUnico().equals(codigoOrden)) {
                    for (DetalleServicio detalle : orden.getListaDetalles()) {
                        if (detalle.getCodigo().equals(codigoDetalle)) {
                            detalle.setTecnico(tecnicoEncontrado);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Equipos> consultarEquiposPendientes() {
        ArrayList<Equipos> equiposPendientes = new ArrayList<>();
        for (OrdenServicio orden : listaOrdenes) {
            for (DetalleServicio detalle : orden.getListaDetalles()) {
                if (detalle.getEstado() != EstadoOrden.FINALIZADA && !equiposPendientes.contains(detalle.getEquipo())) {
                    equiposPendientes.add(detalle.getEquipo());
                }
            }
        }
        return equiposPendientes;
    }

    public String generarReporteServicios() {
        String reporte = "REPORTE DE SERVICIOS\n";
        for (Servicios servicio : listaServicios) {
            int cantidad = 0;
            double total = 0.0;
            for (OrdenServicio orden : listaOrdenes) {
                for (DetalleServicio detalle : orden.getListaDetalles()) {
                    if (detalle.getServicio() == servicio && detalle.getEstado() == EstadoOrden.FINALIZADA) {
                        cantidad++;
                        total += detalle.getServicio().getTarifaBase();
                    }
                }
            }
            reporte += servicio.getNombre() + ": " + cantidad + " | Total: " + total + "\n";
        }
        return reporte;
    }

    public String generarReporteTecnicos() {
        String reporte = "REPORTE DE TÉCNICOS\n";
        for (Tecnico tecnico : listaTecnicos) {
            int cantidad = 0;
            double total = 0.0;
            for (OrdenServicio orden : listaOrdenes) {
                for (DetalleServicio detalle : orden.getListaDetalles()) {
                    if (detalle.getTecnico() == tecnico && detalle.getEstado() == EstadoOrden.FINALIZADA) {
                        cantidad++;
                        if (detalle.getServicio() != null) {
                            total += detalle.getServicio().getTarifaBase();
                        }
                    }
                }
            }
            reporte += tecnico.getNombre() + ": " + cantidad + " trabajos | Total: " + total + "\n";
        }
        return reporte;
    }
}




