package com.ProyectoCarpooling.app.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard-pasajero")
public class PasajeroControlador {

    @GetMapping("/dashboard")
    public String mostrarDashboardPasajero() {
        return "dashboard-pasajero"; // Coincide con dashboard-pasajero.html en templates/
    }
}