package co.edu.uniquindio.poo.model;

public class ComputadorEscritorio extends Equipos{
    private String tipoProcesador;
    private String memoriaRam;
    private String almacenamientoEscritorio;
    private boolean tarjetaGrafica;

    public ComputadorEscritorio(String codigo, String numeroSerie, String marca, String anoFabricacion, String modelo, String descripcion, String tipoProcesador, String memoriaRam, String almacenamiento, boolean tarjetaGrafica) {
        super(codigo, numeroSerie, marca, anoFabricacion, modelo, descripcion);
        this.tipoProcesador = tipoProcesador;
        this.memoriaRam = memoriaRam;
        this.almacenamientoEscritorio = almacenamiento;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public String getTipoProcesador() {
        return tipoProcesador;
    }

    public void setTipoProcesador(String tipoProcesador) {
        this.tipoProcesador = tipoProcesador;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public String getAlmacenamientoEscritorio() {
        return almacenamientoEscritorio;
    }

    public void setAlmacenamientoEscritorio(String almacenamientoEscritorio) {
        this.almacenamientoEscritorio = almacenamientoEscritorio;
    }

    public boolean isTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(boolean tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }
}
