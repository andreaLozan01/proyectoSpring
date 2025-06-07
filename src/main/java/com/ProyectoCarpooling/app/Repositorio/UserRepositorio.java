package com.ProyectoCarpooling.app.Repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoCarpooling.app.Entidad.*;
@Repository
public interface UserRepositorio extends MongoRepository<User, String>{

	User findByEmail(String email);

}
