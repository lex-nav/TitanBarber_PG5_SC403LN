package com.Titan.controller;

import com.Titan.domain.Barbero;
import com.Titan.service.BarberoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/barbero")
public class BarberoController {

    @Autowired
    private BarberoService barberoService;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("barbero", new Barbero());
        return "barbero";
    }

    @PostMapping
    public String guardarBarbero(@ModelAttribute Barbero barbero, RedirectAttributes redirectAttributes) {
        barberoService.guardarBarbero(barbero);
        redirectAttributes.addFlashAttribute("mensaje", "¡Barbero guardado con éxito!");
        return "redirect:/barbero/lista";
    }
    
    @GetMapping("/lista")
    public String listarBarberos(Model model) {
        model.addAttribute("barberos", barberoService.listarBarberos());
        return "listarBarberos";
    }
}