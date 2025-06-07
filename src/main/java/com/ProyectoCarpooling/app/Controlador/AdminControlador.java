package com.ProyectoCarpooling.app.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard-admin")
public class AdminControlador {

    @GetMapping
    public String mostrarDashboardAdmin() {
        return "dashboard-admin"; // Coincide con dashboard-admin.html en templates/
    }
}