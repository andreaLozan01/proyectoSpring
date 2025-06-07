package com.ProyectoCarpooling.app.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard-conductor")
public class ConductorControlador {

    @GetMapping
    public String mostrarDashboardConductor() {
        return "dashboard-conductor"; // Coincide con dashboard-conductor.html en templates/
    }
}