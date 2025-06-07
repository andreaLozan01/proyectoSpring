package com.ProyectoCarpooling.app.Entidad;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "calificaciones")

public class Calificacion {
    @Id
    private String calificacionId;
    private String conductorId;
    private String pasajeroId;
    private int estrellas; // 1-5
    private String comentario;
    private LocalDateTime fechaCalificacion;
    private boolean eliminado; // Para que el Admin pueda eliminar
	
    
    public Calificacion() {
		
	}
    
	public Calificacion(String calificacionId, String conductorId, String pasajeroId, int estrellas, String comentario,
			LocalDateTime fechaCalificacion, boolean eliminado) {
		super();
		this.calificacionId = calificacionId;
		this.conductorId = conductorId;
		this.pasajeroId = pasajeroId;
		this.estrellas = estrellas;
		this.comentario = comentario;
		this.fechaCalificacion = fechaCalificacion;
		this.eliminado = eliminado;
	}

	public String getCalificacionId() {
		return calificacionId;
	}
	public void setCalificacionId(String calificacionId) {
		this.calificacionId = calificacionId;
	}
	public String getConductorId() {
		return conductorId;
	}
	public void setConductorId(String conductorId) {
		this.conductorId = conductorId;
	}
	public String getPasajeroId() {
		return pasajeroId;
	}
	public void setPasajeroId(String pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public LocalDateTime getFechaCalificacion() {
		return fechaCalificacion;
	}
	public void setFechaCalificacion(LocalDateTime fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
    
    
}