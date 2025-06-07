package com.ProyectoCarpooling.app.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoCarpooling.app.Entidad.*;

@Repository
public interface SolicitudRepositorio extends MongoRepository<Solicitud, String> {
}