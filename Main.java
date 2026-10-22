
package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    private static final TechRepair techRepair = new TechRepair("TechRepair", "Armenia, Quindío", "123456");

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion = 0;

        do {
            String menu = """
                    TECHREPAIR
                    =========================
                    1. Registrar cliente
                    2. Consultar cliente
                    3. Mostrar todos los clientes
                    4. Actualizar cliente
                    5. Eliminar cliente

                    6. Registrar equipo
                    7. Consultar equipo
                    8. Mostrar todos los equipos
                    9. Actualizar equipo
                    10. Eliminar equipo

                    11. Registrar repuesto
                    12. Consultar repuesto
                    13. Mostrar todos los repuestos
                    14. Actualizar repuesto
                    15. Eliminar repuesto

                    16. Registrar técnico
                    17. Consultar técnico
                    18. Mostrar todos los técnicos
                    19. Actualizar técnico
                    20. Eliminar técnico

                    21. Registrar servicio
                    22. Crear orden de servicio
                    23. Agregar detalle a una orden
                    24. Asignar técnico a un detalle
                    25. Registrar repuesto utilizado
                    26. Consultar valor de una orden
                    27. Cambiar estado de un detalle
                    28. Finalizar orden

                    29. Consultar trabajos de un técnico
                    30. Consultar inventario crítico
                    31. Consultar órdenes de un cliente
                    32. Consultar equipos pendientes
                    33. Reporte de servicios
                    34. Reporte de técnicos
                    0. Salir
                    """;

            String entrada = JOptionPane.showInputDialog(null, menu, "Menú principal", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                opcion = 0;
                continue;
            }
                opcion = Integer.parseInt(entrada);
                switch (opcion) {
                    case 1: registrarCliente();
                    break;
                    case 2: consultarCliente();
                        break;
                    case 3: mostrarClientes();
                        break;
                    case 4: actualizarCliente();
                        break;
                    case 5: eliminarCliente();
                        break;

                    case 6: registrarEquipo();
                        break;
                    case 7 : consultarEquipo();
                        break;
                    case 8 : mostrarEquipos();
                        break;
                    case 9 : actualizarEquipo();
                        break;
                    case 10 : eliminarEquipo();
                        break;

                    case 11 : registrarRepuesto();
                        break;
                    case 12 : consultarRepuesto();
                        break;
                    case 13 : mostrarRepuestos();
                        break;
                    case 14 : actualizarRepuesto();
                        break;
                    case 15 : eliminarRepuesto();
                        break;

                    case 16 : registrarTecnico();
                        break;
                    case 17 : consultarTecnico();
                        break;
                    case 18 : mostrarTecnicos();
                        break;
                    case 19 : actualizarTecnico();
                        break;
                    case 20 : eliminarTecnico();
                        break;

                    case 21 : registrarServicio();
                        break;
                    case 22 : crearOrden();
                        break;
                    case 23 : agregarDetalle();
                        break;
                    case 24 : asignarTecnico();
                        break;
                    case 25 : registrarRepuestoUtilizado();
                        break;
                    case 26 : consultarValorOrden();
                        break;
                    case 27 : cambiarEstadoDetalle();
                        break;
                    case 28 : finalizarOrden();
                        break;

                    case 29 : consultarTrabajosTecnico();
                        break;
                    case 30 : consultarInventarioCritico();
                        break;
                    case 31 : consultarOrdenesCliente();
                        break;
                    case 32 : consultarEquiposPendientes();
                        break;
                    case 33 : mostrarReporteServicios();
                        break;
                    case 34 : mostrarReporteTecnicos();
                        break;

                    case 0 : JOptionPane.showMessageDialog(
                            null, "Gracias por utilizar TechRepair.");

                    default: mensaje("Selecciona una opción válida.");
                }
        } while (opcion != 0);
    }

    private static String pedirTexto(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);

        if (texto == null) {
            return null;
        }

        if (texto.isEmpty()) {
            mensaje("Este campo no puede estar vacío.");
            return null;
        }

        return texto;
    }

    private static int pedirEntero(String mensaje) {
        String texto = pedirTexto(mensaje);
        if (texto == null) {
            return 0;
        }
        if (texto.length() == 0) {
            mensaje("Debes ingresar un número entero.");
            return 0;
        }
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) < '0' || texto.charAt(i) > '9') {
                mensaje("Debes ingresar un número entero.");
                return 0;
            }
        }
        return Integer.parseInt(texto);
    }
    private static void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    private static boolean cancelar(String... datos) {
        for (String dato : datos) {
            if (dato == null) {
                return true;
            }
        }
        return false;
    }

    private static void registrarCliente() {
        String nombre = pedirTexto("Nombre completo:");
        if (nombre == null) return;

        String telefono = pedirTexto("Teléfono:");
        if (telefono == null) return;

        String documento = pedirTexto("Identificación:");
        if (documento == null) return;

        String correo = pedirTexto("Correo:");
        if (correo == null) return;

        String direccion = pedirTexto("Dirección:");
        if (direccion == null) return;

        Clientes cliente = new Clientes(
                nombre, telefono, documento, correo, direccion);

        mensaje(techRepair.registrarCliente(cliente));
    }

    private static void consultarCliente() {
        String documento = pedirTexto("Identificación del cliente:");
        if (documento == null) return;

        Clientes cliente = techRepair.buscarCliente(documento);

        if (cliente == null) {
            mensaje("No se encontró el cliente.");
        } else {
            mensaje(cliente.toString());
        }
    }

    private static void mostrarClientes() {
        if (techRepair.getListaClientes().size() == 0) {
            mensaje("No hay clientes registrados.");
        } else {
            mensaje(techRepair.getListaClientes().toString());
        }
    }

    private static void actualizarCliente() {
        String documento = pedirTexto("Identificación del cliente:");
        if (documento == null) return;

        String nombre = pedirTexto("Nuevo nombre:");
        if (nombre == null) return;

        String telefono = pedirTexto("Nuevo teléfono:");
        if (telefono == null) return;

        String correo = pedirTexto("Nuevo correo:");
        if (correo == null) return;

        String direccion = pedirTexto("Nueva dirección:");
        if (direccion == null) return;

        mensaje(techRepair.actualizarCliente(
                documento, nombre, telefono, correo, direccion));
    }

    private static void eliminarCliente() {
        String documento = pedirTexto("Identificación del cliente:");
        if (documento == null) return;

        if (techRepair.eliminarCliente(documento)) {
            mensaje("Cliente eliminado correctamente.");
        } else {
            mensaje("No se encontró el cliente.");
        }
    }

    private static void registrarEquipo() {
        String documento = pedirTexto(
                "Identificación del cliente dueño del equipo:");
        if (documento == null) return;

        Clientes cliente = techRepair.buscarCliente(documento);

        if (cliente == null) {
            mensaje("Primero debes registrar al cliente.");
            return;
        }

        String tipo = pedirTexto(
                "Tipo de equipo: PORTATIL, ESCRITORIO o TELEFONO");
        if (tipo == null) return;

        String codigo = pedirTexto("Código del equipo:");
        if (codigo == null) return;

        if (buscarEquipoGlobal(codigo) != null) {
            mensaje("Ya existe un equipo con ese código.");
            return;
        }

        String serie = pedirTexto("Número de serie:");
        if (serie == null) return;

        String marca = pedirTexto("Marca:");
        if (marca == null) return;

        String anio = pedirTexto("Año de fabricación:");
        if (anio == null) return;

        String modelo = pedirTexto("Modelo:");
        if (modelo == null) return;

        String descripcion = pedirTexto("Descripción:");
        if (descripcion == null) return;

        Equipos equipo;

        if (tipo.equalsIgnoreCase("PORTATIL")) {
            String pantalla = pedirTexto("Tamaño de pantalla:");
            if (pantalla == null) return;

            String memoria = pedirTexto("Capacidad de memoria RAM:");
            if (memoria == null) return;

            String bateria = pedirTexto(
                    "¿Tiene batería extraíble? (SI/NO)");
            if (bateria == null) return;

            String almacenamiento = pedirTexto(
                    "Capacidad de almacenamiento:");
            if (almacenamiento == null) return;

            equipo = new ComputadorPortatil(
                    codigo, serie, marca, anio, modelo, descripcion,
                    pantalla, memoria, bateria.equalsIgnoreCase("SI"),
                    almacenamiento);

        } else if (tipo.equalsIgnoreCase("ESCRITORIO")) {
            String procesador = pedirTexto("Tipo de procesador:");
            if (procesador == null) return;

            String memoria = pedirTexto("Memoria RAM:");
            if (memoria == null) return;

            String almacenamiento = pedirTexto("Almacenamiento:");
            if (almacenamiento == null) return;

            String grafica = pedirTexto(
                    "¿Tiene tarjeta gráfica? (SI/NO)");
            if (grafica == null) return;

            equipo = new ComputadorEscritorio(
                    codigo, serie, marca, anio, modelo, descripcion,
                    procesador, memoria, almacenamiento,
                    grafica.equalsIgnoreCase("SI"));

        } else if (tipo.equalsIgnoreCase("TELEFONO")) {
            String sistema = pedirTexto("Sistema operativo:");
            if (sistema == null) return;

            String almacenamiento = pedirTexto("Almacenamiento:");
            if (almacenamiento == null) return;

            String bateria = pedirTexto("Capacidad de batería:");
            if (bateria == null) return;

            String compatible = pedirTexto("¿Compatible con 5G? (SI/NO)");
            if (compatible == null) return;

            equipo = new Telefonos(
                    codigo, serie, marca, anio, modelo, descripcion,
                    sistema, almacenamiento, bateria,
                    compatible.equalsIgnoreCase("SI"));

        } else {
            mensaje("Tipo de equipo no válido.");
            return;
        }

        if (cliente.registrarEquipo(equipo)) {
            techRepair.getListaEquipos().add(equipo);
            mensaje("Equipo registrado correctamente.");
        } else {
            mensaje("No se pudo registrar el equipo.");
        }
    }

    private static Equipos buscarEquipoGlobal(String codigo) {
        for (Equipos equipo : techRepair.getListaEquipos()) {
            if (equipo.getCodigo().equalsIgnoreCase(codigo)) {
                return equipo;
            }
        }
        return null;
    }

    private static void consultarEquipo() {
        String codigo = pedirTexto("Código del equipo:");
        if (codigo == null) return;

        Equipos equipo = buscarEquipoGlobal(codigo);

        if (equipo == null) {
            mensaje("No se encontró el equipo.");
        } else {
            mensaje(equipo.toString());
        }
    }

    private static void mostrarEquipos() {
        if (techRepair.getListaEquipos().size() == 0) {
            mensaje("No hay equipos registrados.");
        } else {
            mensaje(techRepair.getListaEquipos().toString());
        }
    }

    private static void actualizarEquipo() {
        String codigo = pedirTexto("Código del equipo que deseas actualizar:");
        if (codigo == null) return;

        Equipos equipo = buscarEquipoGlobal(codigo);

        if (equipo == null) {
            mensaje("No se encontró el equipo.");
            return;
        }

        String marca = pedirTexto("Nueva marca:");
        if (marca == null) return;

        String modelo = pedirTexto("Nuevo modelo:");
        if (modelo == null) return;

        String anio = pedirTexto("Nuevo año de fabricación:");
        if (anio == null) return;

        String descripcion = pedirTexto("Nueva descripción:");
        if (descripcion == null) return;

        equipo.setMarca(marca);
        equipo.setModelo(modelo);
        equipo.setAnoFabricacion(anio);
        equipo.setDescripcion(descripcion);

        mensaje("Equipo actualizado correctamente.");
    }

    private static void eliminarEquipo() {
        String codigo = pedirTexto("Código del equipo:");
        if (codigo == null) return;

        Equipos equipo = buscarEquipoGlobal(codigo);

        if (equipo == null) {
            mensaje("No se encontró el equipo.");
            return;
        }

        for (Clientes cliente : techRepair.getListaClientes()) {
            if (cliente.eliminarEquipo(codigo)) {
                break;
            }
        }

        techRepair.getListaEquipos().remove(equipo);
        mensaje("Equipo eliminado correctamente.");
    }


    private static void registrarRepuesto() {
        String codigo = pedirTexto("Código del repuesto:");
        if (codigo == null) return;

        String nombre = pedirTexto("Nombre del repuesto:");
        if (nombre == null) return;

        String descripcion = pedirTexto("Descripción:");
        if (descripcion == null) return;

        int precio = pedirEntero("Precio por unidad:");
        if (precio < 0) return;

        int cantidad = pedirEntero("Cantidad disponible:");
        if (cantidad < 0) return;

        String categoria = pedirTexto("Categoría de compatibilidad:");
        if (categoria == null) return;

        Repuestos repuesto = new Repuestos(
                codigo, nombre, descripcion, precio, cantidad, categoria);

        if (techRepair.registrarRepuesto(repuesto)) {
            mensaje("Repuesto registrado correctamente.");
        } else {
            mensaje("Ya existe un repuesto con ese código.");
        }
    }

    private static void consultarRepuesto() {
        String codigo = pedirTexto("Código del repuesto:");
        if (codigo == null) return;

        Repuestos repuesto = techRepair.buscarRepuesto(codigo);

        if (repuesto == null) {
            mensaje("No se encontró el repuesto.");
        } else {
            mensaje(repuesto.toString());
        }
    }

    private static void mostrarRepuestos() {
        if (techRepair.getListaRepuestos().size() == 0) {
            mensaje("No hay repuestos registrados.");
        } else {
            mensaje(techRepair.getListaRepuestos().toString());
        }
    }

    private static void actualizarRepuesto() {
        String codigo = pedirTexto("Código del repuesto que deseas actualizar:");
        if (codigo == null) return;

        Repuestos actual = techRepair.buscarRepuesto(codigo);

        if (actual == null) {
            mensaje("No se encontró el repuesto.");
            return;
        }

        String nombre = pedirTexto("Nuevo nombre:");
        if (nombre == null) return;

        int precio = pedirEntero("Nuevo precio:");
        if (precio < 0) return;

        int cantidad = pedirEntero("Nueva cantidad disponible:");
        if (cantidad < 0) return;

        Repuestos nuevo = new Repuestos(
                actual.getCodigoUnico(), nombre,
                actual.getDescripcionRepuesto(), precio, cantidad,
                actual.getCategoriaCompatibilidad());

        if (techRepair.editarRepuesto(codigo, nuevo)) {
            mensaje("Repuesto actualizado correctamente.");
        } else {
            mensaje("No se pudo actualizar el repuesto.");
        }
    }

    private static void eliminarRepuesto() {
        String codigo = pedirTexto("Código del repuesto:");
        if (codigo == null) return;

        if (techRepair.eliminarRepuesto(codigo)) {
            mensaje("Repuesto eliminado correctamente.");
        } else {
            mensaje("No se encontró el repuesto.");
        }
    }


    private static void registrarTecnico() {
        String nombre = pedirTexto("Nombre del técnico:");
        if (nombre == null) return;

        String documento = pedirTexto("Documento:");
        if (documento == null) return;

        String especialidad = pedirTexto("Especialidad:");
        if (especialidad == null) return;

        String estado = pedirTexto("Estado laboral:");
        if (estado == null) return;

        Tecnico tecnico = new Tecnico(
                nombre, documento, especialidad, estado);

        if (techRepair.registrarTecnico(tecnico)) {
            mensaje("Técnico registrado correctamente.");
        } else {
            mensaje("Ya existe un técnico con ese documento.");
        }
    }

    private static void consultarTecnico() {
        String documento = pedirTexto("Documento del técnico:");
        if (documento == null) return;

        Tecnico tecnico = techRepair.buscarTecnico(documento);

        if (tecnico == null) {
            mensaje("No se encontró el técnico.");
        } else {
            mensaje(tecnico.toString());
        }
    }

    private static void mostrarTecnicos() {
        if (techRepair.getListaTecnicos().size() == 0) {
            mensaje("No hay técnicos registrados.");
        } else {
            mensaje(techRepair.getListaTecnicos().toString());
        }
    }

    private static void actualizarTecnico() {
        String documento = pedirTexto("Documento del técnico:");
        if (documento == null) return;

        String nombre = pedirTexto("Nuevo nombre:");
        if (nombre == null) return;

        String especialidad = pedirTexto("Nueva especialidad:");
        if (especialidad == null) return;

        String estado = pedirTexto("Nuevo estado laboral:");
        if (estado == null) return;

        Tecnico nuevo = new Tecnico(nombre, documento, especialidad, estado);

        if (techRepair.actualizarTecnico(documento, nuevo)) {
            mensaje("Técnico actualizado correctamente.");
        } else {
            mensaje("No se encontró el técnico.");
        }
    }

    private static void eliminarTecnico() {
        String documento = pedirTexto("Documento del técnico:");
        if (documento == null) return;

        if (techRepair.eliminarTecnico(documento)) {
            mensaje("Técnico eliminado correctamente.");
        } else {
            mensaje("No se encontró el técnico.");
        }
    }


    private static void registrarServicio() {
        String tipo = pedirTexto(
                "Tipo: DIAGNOSTICO, MANTENIMIENTO o REPARACION");
        if (tipo == null) return;

        String codigo = pedirTexto("Código del servicio:");
        if (codigo == null) return;

        String nombre = pedirTexto("Nombre:");
        if (nombre == null) return;

        String descripcion = pedirTexto("Descripción:");
        if (descripcion == null) return;

        int tarifa = pedirEntero("Tarifa base:");
        if (tarifa < 0) return;

        Servicios servicio;

        if (tipo.equalsIgnoreCase("DIAGNOSTICO")) {
            servicio = new Diagnostico(codigo, nombre, descripcion, tarifa);
        } else if (tipo.equalsIgnoreCase("MANTENIMIENTO")) {
            servicio = new MantenimientoPreventivo(
                    codigo, nombre, descripcion, tarifa);
        } else if (tipo.equalsIgnoreCase("REPARACION")) {
            int horas = pedirEntero("Horas de trabajo:");
            if (horas < 0) return;

            servicio = new ReparacionCorrectiva(
                    codigo, nombre, descripcion, tarifa, horas);
        } else {
            mensaje("Tipo de servicio no válido.");
            return;
        }

        techRepair.getListaServicios().add(servicio);
        mensaje("Servicio registrado correctamente.");
    }


    private static void crearOrden() {
        String codigo = pedirTexto("Código de la orden:");
        if (codigo == null) return;

        String documento = pedirTexto("Identificación del cliente:");
        if (documento == null) return;

        String observaciones = pedirTexto("Observaciones:");
        if (observaciones == null) return;

        if (techRepair.crearOrdenServicio(codigo, documento, observaciones)) {
            mensaje("Orden de servicio creada correctamente.");
        } else {
            mensaje("No se pudo crear la orden. Verifica el cliente "
                    + "y que el código no esté repetido.");
        }
    }

    private static void agregarDetalle() {
        String codigoOrden = pedirTexto("Código de la orden:");
        if (codigoOrden == null) return;

        String codigoDetalle = pedirTexto("Código del detalle:");
        if (codigoDetalle == null) return;

        String codigoEquipo = pedirTexto("Código del equipo:");
        if (codigoEquipo == null) return;

        Equipos equipo = buscarEquipoGlobal(codigoEquipo);

        if (equipo == null) {
            mensaje("No se encontró el equipo.");
            return;
        }

        if (techRepair.getListaServicios().size() == 0) {
            mensaje("Primero debes registrar un servicio.");
            return;
        }

        String codigoServicio = pedirTexto("Código del servicio:");
        if (codigoServicio == null) return;

        Servicios servicio = null;

        for (Servicios s : techRepair.getListaServicios()) {
            if (s.getCodigoServicio().equalsIgnoreCase(codigoServicio)) {
                servicio = s;
                break;
            }
        }

        if (servicio == null) {
            mensaje("No se encontró el servicio.");
            return;
        }

        String falla = pedirTexto("Descripción de la falla:");
        if (falla == null) return;

        int horas = pedirEntero("Horas de trabajo:");
        if (horas < 0) return;

        DetalleServicio detalle = new DetalleServicio(
                codigoDetalle, equipo, servicio, falla, null, horas);

        if (techRepair.agregarDetalleOrden(codigoOrden, detalle)) {
            mensaje("Detalle agregado correctamente.");
        } else {
            mensaje("No se pudo agregar. Verifica la orden y el código "
                    + "del detalle.");
        }
    }

    private static void asignarTecnico() {
        String orden = pedirTexto("Código de la orden:");
        if (orden == null) return;

        String detalle = pedirTexto("Código del detalle:");
        if (detalle == null) return;

        String documento = pedirTexto("Documento del técnico:");
        if (documento == null) return;

        if (techRepair.asignarTecnico(orden, detalle, documento)) {
            mensaje("Técnico asignado correctamente.");
        } else {
            mensaje("No se pudo asignar el técnico. Verifica los códigos.");
        }
    }

    private static void registrarRepuestoUtilizado() {
        String orden = pedirTexto("Código de la orden:");
        if (orden == null) return;

        String detalle = pedirTexto("Código del detalle:");
        if (detalle == null) return;

        String codigo = pedirTexto("Código del repuesto:");
        if (codigo == null) return;

        int cantidad = pedirEntero("Cantidad utilizada:");
        if (cantidad <= 0) return;

        if (techRepair.registrarRepuestoUtilizado(
                orden, detalle, codigo, cantidad)) {
            mensaje("Repuesto registrado en el detalle. "
                    + "El inventario fue actualizado.");
        } else {
            mensaje("No se pudo registrar. Revisa la orden, el detalle, "
                    + "el repuesto y la cantidad disponible.");
        }
    }

    private static void consultarValorOrden() {
        String codigo = pedirTexto("Código de la orden:");
        if (codigo == null) return;

        boolean encontrada = false;

        for (OrdenServicio orden : techRepair.getListaOrdenes()) {
            if (orden.getCodigoUnico().equalsIgnoreCase(codigo)) {
                encontrada = true;
                break;
            }
        }

        if (encontrada) {
            mensaje("Valor total de la orden: $"
                    + techRepair.calcularValorTotalOrden(codigo));
        } else {
            mensaje("No se encontró la orden.");
        }
    }

    private static void cambiarEstadoDetalle() {
        String orden = pedirTexto("Código de la orden:");
        if (orden == null) return;

        String detalle = pedirTexto("Código del detalle:");
        if (detalle == null) return;

        String estado = pedirTexto("Nuevo estado: ABIERTA o FINALIZADA");
        if (estado == null) return;

        EstadoOrden nuevoEstado;

        if (estado.equalsIgnoreCase("ABIERTA")) {
            nuevoEstado = EstadoOrden.ABIERTA;
        } else if (estado.equalsIgnoreCase("FINALIZADA")) {
            nuevoEstado = EstadoOrden.FINALIZADA;
        } else {
            mensaje("Estado no válido.");
            return;
        }

        if (techRepair.actualizarEstadoDetalle(orden, detalle, nuevoEstado)) {
            mensaje("Estado actualizado correctamente.");
        } else {
            mensaje("No se encontró la orden o el detalle.");
        }
    }

    private static void finalizarOrden() {
        String codigo = pedirTexto("Código de la orden:");
        if (codigo == null) return;

        if (techRepair.finalizarOrden(codigo)) {
            mensaje("Orden finalizada correctamente.");
        } else {
            mensaje("No se pudo finalizar. Verifica que tenga detalles "
                    + "y que todos estén finalizados.");
        }
    }


    private static void consultarTrabajosTecnico() {
        String documento = pedirTexto("Documento del técnico:");
        if (documento == null) return;

        ArrayList<DetalleServicio> trabajos =
                techRepair.consultarTrabajosTecnico(documento);

        if (trabajos.size() == 0) {
            mensaje("Este técnico no tiene trabajos registrados.");
        } else {
            mensaje(trabajos.toString());
        }
    }

    private static void consultarInventarioCritico() {
        ArrayList<Repuestos> lista =
                techRepair.consultarInventarioCritico();

        if (lista.size() == 0) {
            mensaje("No hay repuestos con inventario crítico.");
        } else {
            mensaje("REPUESTOS CON MENOS DE 5 UNIDADES:\n" + lista);
        }
    }

    private static void consultarOrdenesCliente() {
        String documento = pedirTexto("Identificación del cliente:");
        if (documento == null) return;

        ArrayList<OrdenServicio> ordenes =
                techRepair.consultarOrdenesCliente(documento);

        if (ordenes.size() == 0) {
            mensaje("El cliente no tiene órdenes registradas.");
        } else {
            mensaje(ordenes.toString());
        }
    }

    private static void consultarEquiposPendientes() {
        ArrayList<Equipos> equipos =
                techRepair.consultarEquiposPendientes();

        if (equipos.size() == 0) {
            mensaje("No hay equipos pendientes.");
        } else {
            mensaje(equipos.toString());
        }
    }

    private static void mostrarReporteServicios() {
        mensaje(techRepair.generarReporteServicios());
    }

    private static void mostrarReporteTecnicos() {
        mensaje(techRepair.generarReporteTecnicos());
    }
}
