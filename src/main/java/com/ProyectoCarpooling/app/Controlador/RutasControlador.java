package com.ProyectoCarpooling.app.Controlador;

import com.ProyectoCarpooling.app.Entidad.*;
import com.ProyectoCarpooling.app.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutas")
public class RutasControlador {

    @Autowired
    private RutasRepositorio rutasRepository;

    @PostMapping
    public Rutas crearRuta(@RequestBody Rutas ruta) {
        // Validar precio en el backend (opcional)
        if (ruta.getPrecio() > 4000) {
            throw new RuntimeException("El precio no puede ser mayor a 4000 COP.");
        }
        if (ruta.getPrecio() < 0) {
            throw new RuntimeException("El precio no puede ser negativo.");
        }
        return rutasRepository.save(ruta);
    }

    @GetMapping
    public List<Rutas> getAllRutas() {
        return rutasRepository.findAll();
    }

    @PutMapping("/{rutaId}")
    public Rutas actualizarRuta(@PathVariable String rutaId, @RequestBody Rutas rutaDetails) {
        Rutas ruta = rutasRepository.findById(rutaId).orElseThrow(() -> new RuntimeException("Ruta no encontrada"));
        ruta.setOrigen(rutaDetails.getOrigen());
        ruta.setDestino(rutaDetails.getDestino());
        ruta.setFechaHora(rutaDetails.getFechaHora());
        ruta.setDias(rutaDetails.getDias());
        ruta.setCuposDisponibles(rutaDetails.getCuposDisponibles());
        ruta.setPrecio(rutaDetails.getPrecio()); // Agregar actualización del precio
        ruta.setActiva(rutaDetails.isActiva());
        ruta.setEstado(rutaDetails.getEstado());
        ruta.setDuracion(rutaDetails.getDuracion());

        // Validar precio en el backend (opcional)
        if (ruta.getPrecio() > 4000) {
            throw new RuntimeException("El precio no puede ser mayor a 4000 COP.");
        }
        if (ruta.getPrecio() < 0) {
            throw new RuntimeException("El precio no puede ser negativo.");
        }

        return rutasRepository.save(ruta);
    }

    @DeleteMapping("/{rutaId}")
    public void eliminarRuta(@PathVariable String rutaId) {
        rutasRepository.deleteById(rutaId);
    }
}