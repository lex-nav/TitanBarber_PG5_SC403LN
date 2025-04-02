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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;



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
    public String agendarCita(@ModelAttribute Cita cita, RedirectAttributes redirectAttributes) {
        citaService.agendarCita(cita);
        redirectAttributes.addFlashAttribute("mensaje", "¡Cita agendada con éxito!");
        return "redirect:/agenda";
    }
    
    @GetMapping("/mis-citas")
    public String listarMisCitas(@AuthenticationPrincipal User user, Model model) {
        Cliente cliente = clienteService.obtenerClientePorCorreo(user.getUsername());
        List<Cita> citas = citaService.buscarCitasPorCliente(cliente);
        model.addAttribute("citas", citas);
        return "misCitas";
    }
    
    @GetMapping("/cancelar/{id}")
    public String cancelarCita(@PathVariable("id") Integer id, @AuthenticationPrincipal User user, RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteService.obtenerClientePorCorreo(user.getUsername());
        Cita cita = citaService.obtenerCitaPorId(id);

        if (cita != null && cita.getCliente().getId().equals(cliente.getId())) {
            citaService.cancelarCita(id);
            redirectAttributes.addFlashAttribute("mensaje", "Cita cancelada correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "No tienes permiso para cancelar esta cita.");
        }

        return "redirect:/agenda/mis-citas"; 
    }

}
