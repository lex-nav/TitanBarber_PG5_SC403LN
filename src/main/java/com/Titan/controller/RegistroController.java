package com.Titan.controller;

import com.Titan.domain.Cliente;
import com.Titan.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistroController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro";
    }

   @PostMapping("/registro")
    public String registrarCliente(@ModelAttribute Cliente cliente) {
        cliente.setRol("CLIENTE"); // ✅ Forzamos el rol antes de guardar
        clienteService.guardarCliente(cliente);
            return "redirect:/login"; // Redirige al login después de registrarse
    }

}