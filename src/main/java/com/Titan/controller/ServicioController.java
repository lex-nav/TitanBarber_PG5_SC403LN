package com.Titan.controller;

import com.Titan.domain.Servicio;
import com.Titan.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicio";
    }

    @PostMapping
    public String guardarServicio(@ModelAttribute Servicio servicio, RedirectAttributes redirectAttributes) {
        servicioService.guardarServicio(servicio);
        redirectAttributes.addFlashAttribute("mensaje", "¡Servicio guardado con éxito!");
        return "redirect:/servicio/lista";
    }
    
    @GetMapping("/lista")
    public String listarServicios(Model model) {
        model.addAttribute("servicios", servicioService.listarServicios());
        return "listarServicios";
    }
    
    @GetMapping("/servicios")
    public String mostrarServicios(Model model) {
        model.addAttribute("servicios", servicioService.listarServicios());
        return "listarServicios";
    }

}