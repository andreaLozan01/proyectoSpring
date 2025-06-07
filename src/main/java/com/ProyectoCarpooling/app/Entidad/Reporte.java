package com.ProyectoCarpooling.app.Entidad;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "reportes")

public class Reporte {
    @Id
    private String reporteId;
    private String usuarioId;
    private String tipo; // GRAVE, LEVE
    private String descripcion;
    private LocalDateTime fechaReporte;
    private boolean resuelto;
    
    
	public Reporte() {
		
	}
	
	public Reporte(String reporteId, String usuarioId, String tipo, String descripcion, LocalDateTime fechaReporte,
			boolean resuelto) {
		super();
		this.reporteId = reporteId;
		this.usuarioId = usuarioId;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.fechaReporte = fechaReporte;
		this.resuelto = resuelto;
	}

	public String getReporteId() {
		return reporteId;
	}
	public void setReporteId(String reporteId) {
		this.reporteId = reporteId;
	}
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDateTime getFechaReporte() {
		return fechaReporte;
	}
	public void setFechaReporte(LocalDateTime fechaReporte) {
		this.fechaReporte = fechaReporte;
	}
	public boolean isResuelto() {
		return resuelto;
	}
	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}
    
    
}