package com.Titan.controller;

import com.Titan.domain.Cliente;
import com.Titan.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String verPerfil(Model model, Authentication auth) {
        Cliente cliente = clienteService.obtenerClientePorCorreo(auth.getName());
        model.addAttribute("cliente", cliente);
        return "perfil";
    }

//    @PostMapping
//    public String actualizarPerfil(@ModelAttribute Cliente cliente, Authentication auth) {
//        Cliente actual = clienteService.obtenerClientePorCorreo(auth.getName());
//        actual.setNombre(cliente.getNombre());
//        actual.setApellido(cliente.getApellido());
//        actual.setTelefono(cliente.getTelefono());
//        actual.setContraseña(cliente.getContraseña());
//        clienteService.actualizarCliente(actual);
//        return "redirect:/perfil?exito";
    
    //    }
    @GetMapping("/editar")
    public String mostrarFormularioEdicion(Model model, Authentication auth) {
        Cliente cliente = clienteService.obtenerClientePorCorreo(auth.getName());
        model.addAttribute("cliente", cliente);
        return "editarPerfil";
    }

    @PostMapping("/editar")
    public String actualizarPerfilDesdeVista(@ModelAttribute Cliente cliente, Authentication auth) {
        Cliente actual = clienteService.obtenerClientePorCorreo(auth.getName());
        actual.setNombre(cliente.getNombre());
        actual.setApellido(cliente.getApellido());
        actual.setTelefono(cliente.getTelefono());
        actual.setContraseña(cliente.getContraseña());
        clienteService.actualizarCliente(actual);
        return "redirect:/perfil?exito";
    }


}
