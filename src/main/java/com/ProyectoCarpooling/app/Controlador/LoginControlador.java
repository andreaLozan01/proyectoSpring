package com.ProyectoCarpooling.app.Controlador;

     import org.springframework.stereotype.Controller;
     import org.springframework.web.bind.annotation.GetMapping;
     import org.springframework.web.bind.annotation.RequestMapping;

     @Controller
     @RequestMapping("/login")
     public class LoginControlador {

         @GetMapping
         public String mostrarLogin() {
             return "Login"; // Coincide con dashboard-conductor.html en templates/
         }
     }