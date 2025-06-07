package com.ProyectoCarpooling.app.Controlador;

import com.ProyectoCarpooling.app.Entidad.*;
import com.ProyectoCarpooling.app.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionControlador {

    @Autowired
    private CalificacionRepositorio calificacionRepository;

    @PostMapping
    public Calificacion crearCalificacion(@RequestBody Calificacion calificacion) {
        calificacion.setFechaCalificacion(LocalDateTime.now());
        return calificacionRepository.save(calificacion);
    }

    @DeleteMapping("/{calificacionId}")
    public void eliminarCalificacion(@PathVariable String calificacionId) {
        Calificacion calificacion = calificacionRepository.findById(calificacionId).orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
        calificacion.setEliminado(true);
        calificacionRepository.save(calificacion);
    }
}