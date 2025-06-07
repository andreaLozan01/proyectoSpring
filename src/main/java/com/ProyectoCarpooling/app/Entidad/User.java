package com.ProyectoCarpooling.app.Entidad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")

public class User {
    @Id
    private String userId;
    private String nombre;
    private String rol; // CONDUCTOR, COORDINADOR, INVITADO, PASAJERO, ADMINISTRADOR
    private String email;
    private String password;
    private String celular;
    private String universidad;
    private String estado; // ACTIVO, INACTIVO, PENDIENTE (para Invitado)
    private String coordinadorId; // Para vincular con un Coordinador Institucional
    private boolean aprobado; // Para Invitado
	
    
    
    public User() {
		
	}
    
    
	public User(String userId, String nombre, String rol, String email, String password, String celular, String universidad,
			String estado, String coordinadorId, boolean aprobado) {
		super();
		this.userId = userId;
		this.nombre = nombre;
		this.rol = rol;
		this.email = email;
		this.password = password;
		this.celular = celular;
		this.universidad = universidad;
		this.estado = estado;
		this.coordinadorId = coordinadorId;
		this.aprobado = aprobado;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCoordinadorId() {
		return coordinadorId;
	}
	public void setCoordinadorId(String coordinadorId) {
		this.coordinadorId = coordinadorId;
	}
	public boolean isAprobado() {
		return aprobado;
	}
	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}
    
    
}