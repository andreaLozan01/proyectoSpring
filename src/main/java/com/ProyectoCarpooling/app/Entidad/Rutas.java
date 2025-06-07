package com.ProyectoCarpooling.app.Entidad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "rutas")
public class Rutas {

    @Id
    private String rutaId;
    private String conductorId;
    private String origen;
    private String destino;
    private LocalDateTime fechaHora;
    private List<String> dias;
    private int cuposDisponibles;
    private int precio; // Nuevo campo para el precio
    private boolean activa;
    private String estado; // ACTIVA, EN CURSO, PASADA
    private List<String> pasajerosConfirmados;
    private List<String> solicitudesPendientes;
    private long duracion;

    // Constructores
    public Rutas() {}

    public Rutas(String rutaId, String conductorId, String origen, String destino, LocalDateTime fechaHora,
                 List<String> dias, int cuposDisponibles, int precio, boolean activa, String estado,
                 List<String> pasajerosConfirmados, List<String> solicitudesPendientes, long duracion) {
        this.rutaId = rutaId;
        this.conductorId = conductorId;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.dias = dias;
        this.cuposDisponibles = cuposDisponibles;
        this.precio = precio;
        this.activa = activa;
        this.estado = estado;
        this.pasajerosConfirmados = pasajerosConfirmados;
        this.solicitudesPendientes = solicitudesPendientes;
        this.duracion = duracion;
    }

    // Getters y setters
    public String getRutaId() { return rutaId; }
    public void setRutaId(String rutaId) { this.rutaId = rutaId; }
    public String getConductorId() { return conductorId; }
    public void setConductorId(String conductorId) { this.conductorId = conductorId; }
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public List<String> getDias() { return dias; }
    public void setDias(List<String> dias) { this.dias = dias; }
    public int getCuposDisponibles() { return cuposDisponibles; }
    public void setCuposDisponibles(int cuposDisponibles) { this.cuposDisponibles = cuposDisponibles; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public List<String> getPasajerosConfirmados() { return pasajerosConfirmados; }
    public void setPasajerosConfirmados(List<String> pasajerosConfirmados) { this.pasajerosConfirmados = pasajerosConfirmados; }
    public List<String> getSolicitudesPendientes() { return solicitudesPendientes; }
    public void setSolicitudesPendientes(List<String> solicitudesPendientes) { this.solicitudesPendientes = solicitudesPendientes; }
    public long getDuracion() { return duracion; }
    public void setDuracion(long duracion) { this.duracion = duracion; }
}