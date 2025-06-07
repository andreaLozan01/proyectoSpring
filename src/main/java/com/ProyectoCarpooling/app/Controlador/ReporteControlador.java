package com.ProyectoCarpooling.app.Controlador;

import com.ProyectoCarpooling.app.Entidad.*;
import com.ProyectoCarpooling.app.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reportes")
public class ReporteControlador {

    @Autowired
    private ReporteRepositorio reporteRepository;

    @PostMapping
    public Reporte crearReporte(@RequestBody Reporte reporte) {
        reporte.setFechaReporte(LocalDateTime.now());
        return reporteRepository.save(reporte);
    }

    @PutMapping("/{reporteId}")
    public Reporte actualizarReporte(@PathVariable String reporteId, @RequestBody Reporte reporteDetails) {
        Reporte reporte = reporteRepository.findById(reporteId).orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
        reporte.setResuelto(reporteDetails.isResuelto());
        return reporteRepository.save(reporte);
    }
}