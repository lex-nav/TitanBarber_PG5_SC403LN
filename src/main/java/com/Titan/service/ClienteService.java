package com.Titan.service;

import com.Titan.domain.Cliente;
import java.util.List;

public interface ClienteService {
    void guardarCliente(Cliente cliente);
    Cliente buscarPorCorreo(String correo);
    List<Cliente> listarClientes();
}
