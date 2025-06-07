package com.ProyectoCarpooling.app.Controlador;

import com.ProyectoCarpooling.app.Entidad.Rutas;
import com.ProyectoCarpooling.app.Entidad.Solicitud;
import com.ProyectoCarpooling.app.Repositorio.RutasRepositorio;
import com.ProyectoCarpooling.app.Repositorio.SolicitudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudControlador {

    @Autowired
    private SolicitudRepositorio solicitudRepository;
    @Autowired
    private RutasRepositorio routeRepository;

    @PostMapping
    public Solicitud enviarSolicitud(@RequestBody Solicitud solicitud) {
        List<Solicitud> solicitudesExistentes = solicitudRepository.findAll().stream()
                .filter(s -> s.getPasajeroId().equals(solicitud.getPasajeroId())
                        && s.getRutaId().equals(solicitud.getRutaId())
                        && !s.getEstado().equals("RECHAZADO")
                        && !s.getEstado().equals("CANCELADO"))
                .collect(Collectors.toList());

        if (!solicitudesExistentes.isEmpty()) {
            throw new RuntimeException("Ya tienes una solicitud pendiente o aceptada para esta ruta.");
        }

        solicitud.setEstado("PENDIENTE");
        solicitud.setFechaSolicitud(LocalDateTime.now());
        return solicitudRepository.save(solicitud);
    }

    @GetMapping("/ruta/{rutaId}")
    public List<Solicitud> getSolicitudesPorRuta(@PathVariable String rutaId) {
        return solicitudRepository.findAll().stream()
                .filter(s -> s.getRutaId().equals(rutaId))
                .collect(Collectors.toList());
    }

    @GetMapping("/pasajero/{pasajeroId}")
    public List<Solicitud> getSolicitudesPorPasajero(@PathVariable String pasajeroId) {
        return solicitudRepository.findAll().stream()
                .filter(s -> s.getPasajeroId().equals(pasajeroId))
                .collect(Collectors.toList());
    }

    @PutMapping("/{solicitudId}")
    public Solicitud actualizarSolicitud(@PathVariable String solicitudId, @RequestBody Solicitud solicitudDetails) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        // Actualizar el estado de la solicitud
        solicitud.setEstado(solicitudDetails.getEstado());

        // Si se acepta, actualizar la ruta asociada
        if ("ACEPTADO".equals(solicitudDetails.getEstado())) {
            String rutaId = solicitud.getRutaId();
            Rutas ruta = routeRepository.findById(rutaId)
                    .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));
            if (ruta.getCuposDisponibles() > 0) {
                ruta.setCuposDisponibles(ruta.getCuposDisponibles() - 1);
                if (ruta.getCuposDisponibles() == 0) {
                    ruta.setActiva(false);
                }
                routeRepository.save(ruta);
            } else {
                throw new RuntimeException("No hay cupos disponibles en la ruta.");
            }
        }

        return solicitudRepository.save(solicitud);
    }
}