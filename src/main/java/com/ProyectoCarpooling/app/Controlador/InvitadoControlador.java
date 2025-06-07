package com.ProyectoCarpooling.app.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard-invitado")
public class InvitadoControlador {

    @GetMapping
    public String mostrarDashboardInvitado() {
        return "dashboard-invitado"; // Coincide con dashboard-invitado.html en templates/
    }
}