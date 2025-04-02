package com.Titan.controller;

import com.Titan.domain.Cliente;
import com.Titan.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/lista")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "listarClientes";
    }

    @PostMapping("/actualizar")
    public String actualizarRol(@RequestParam("id") Integer id, @RequestParam("rol") String rol) {
        Cliente cliente = clienteService.obtenerCliente(id);
        if (cliente != null) {
            cliente.setRol(rol.toUpperCase());
            clienteService.actualizarCliente(cliente);
        }
        return "redirect:/usuarios/lista";
    }
}
