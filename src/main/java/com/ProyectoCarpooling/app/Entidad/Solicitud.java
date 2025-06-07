package com.ProyectoCarpooling.app.Entidad;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "solicitudes")

public class Solicitud {
    @Id
    private String solicitudId;
    private String rutaId;
    private String pasajeroId;
    private String estado; // PENDIENTE, ACEPTADO, RECHAZADO, CANCELADO
    private LocalDateTime fechaSolicitud;
	
    
    
    public Solicitud() {
		
	}
	public Solicitud(String solicitudId, String rutaId, String pasajeroId, String estado,
			LocalDateTime fechaSolicitud) {
		super();
		this.solicitudId = solicitudId;
		this.rutaId = rutaId;
		this.pasajeroId = pasajeroId;
		this.estado = estado;
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getSolicitudId() {
		return solicitudId;
	}
	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}
	public String getRutaId() {
		return rutaId;
	}
	public void setRutaId(String rutaId) {
		this.rutaId = rutaId;
	}
	public String getPasajeroId() {
		return pasajeroId;
	}
	public void setPasajeroId(String pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public LocalDateTime getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
    
    
}