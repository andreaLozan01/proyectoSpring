package com.ProyectoCarpooling.app.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard-coordinador")
public class CoordinadorControlador {

    @GetMapping
    public String mostrarDashboardCoordinador() {
        return "dashboard-coordinador"; // Coincide con dashboard-coordinador.html en templates/
    }
}