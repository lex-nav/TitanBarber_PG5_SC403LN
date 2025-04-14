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
    
    @GetMapping("/editar/{id}")
    public String editarBarbero(@PathVariable("id") Integer id, Model model) {
        Barbero barbero = barberoService.obtenerBarberoPorId(id);
        model.addAttribute("barbero", barbero);
        return "editarBarbero";
    }

    @PostMapping("/actualizar")
    public String actualizarBarbero(@ModelAttribute Barbero barbero, RedirectAttributes redirectAttributes) {
        barberoService.guardarBarbero(barbero);
        redirectAttributes.addFlashAttribute("mensaje", "Barbero actualizado correctamente.");
        return "redirect:/barbero/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarBarbero(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        if (barberoService.tieneCitasAsignadas(id)) {
            redirectAttributes.addFlashAttribute("mensaje", "No se puede eliminar el barbero porque tiene citas asignadas.");
        } else {
            barberoService.eliminarBarbero(id);
            redirectAttributes.addFlashAttribute("mensaje", "Barbero eliminado correctamente.");
        }
        return "redirect:/barbero/lista";
}


    @GetMapping("/lista")
    public String listarBarberos(Model model) {
        model.addAttribute("barberos", barberoService.listarBarberos());
        return "listarBarberos";
    }
}