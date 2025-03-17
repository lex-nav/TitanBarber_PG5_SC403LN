package com.Titan.controller;

import com.Titan.domain.Cita;
import com.Titan.domain.Cliente;
import com.Titan.domain.Barbero;
import com.Titan.domain.Servicio;
import com.Titan.service.CitaService;
import com.Titan.service.ClienteService;
import com.Titan.service.BarberoService;
import com.Titan.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agenda")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BarberoService barberoService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String mostrarFormularioAgenda(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("barberos", barberoService.listarBarberos());
        model.addAttribute("servicios", servicioService.listarServicios());
        return "agenda";
    }

    @PostMapping
    public String agendarCita(@ModelAttribute Cita cita) {
        citaService.agendarCita(cita);
        return "redirect:/agenda";
    }
}
