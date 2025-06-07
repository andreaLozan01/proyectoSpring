package com.ProyectoCarpooling.app.Controlador;

import com.ProyectoCarpooling.app.Entidad.*;
import com.ProyectoCarpooling.app.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControlador {
    @Autowired
    private UserRepositorio userRepository;

    @PostMapping
    public User crearUsuario(@RequestBody User user) {
        if (user.getRol() != null) {
            user.setRol(user.getRol().toLowerCase().replace("administrador", "Admin"));
        }
        // Establecer aprobado a true si el usuario es "Usuario Invitado" y se crea con estado "ACTIVO"
        if ("usuario invitado".equals(user.getRol()) && "ACTIVO".equals(user.getEstado())) {
            user.setAprobado(true);
        } else {
            user.setAprobado(user.isAprobado()); // Respetar el valor enviado, si existe
        }
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        return userRepository.findById(userId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public User actualizarUsuario(@PathVariable String userId, @RequestBody User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        // Actualizar los campos básicos
        user.setNombre(userDetails.getNombre());
        user.setEmail(userDetails.getEmail());
        user.setCelular(userDetails.getCelular());
        user.setUniversidad(userDetails.getUniversidad());
        if (userDetails.getRol() != null) {
            user.setRol(userDetails.getRol().toLowerCase().replace("administrador", "Admin"));
        }
        user.setEstado(userDetails.getEstado());

        // Lógica para manejar el campo aprobado
        if ("usuario invitado".equals(user.getRol()) && "ACTIVO".equals(userDetails.getEstado()) && !user.isAprobado()) {
            user.setAprobado(true); // Establecer aprobado a true solo la primera vez que se activa
        } else {
            // Respetar el valor de aprobado enviado por el frontend en otros casos
            user.setAprobado(userDetails.isAprobado());
        }

        return userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public void eliminarUsuario(@PathVariable String userId) {
        userRepository.deleteById(userId);
    }

    @PutMapping("/{userId}/estado")
    public User activarDesactivarUsuario(@PathVariable String userId, @RequestBody String estado) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        user.setEstado(estado);

        // Aplicar la misma lógica para aprobado en este endpoint
        if ("usuario invitado".equals(user.getRol()) && "ACTIVO".equals(estado) && !user.isAprobado()) {
            user.setAprobado(true);
        }

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (user.getRol() != null) {
            user.setRol(user.getRol().toLowerCase().replace("administrador", "Admin"));
        }
        // Verificar si el usuario puede iniciar sesión
        if ("usuario invitado".equals(user.getRol()) && !user.isAprobado()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (!"ACTIVO".equals(user.getEstado())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(user);
    }
}
