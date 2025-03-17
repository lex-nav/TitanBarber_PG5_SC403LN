package com.Titan.service.impl;

import com.Titan.dao.ClienteDao;
import com.Titan.domain.Cliente;
import com.Titan.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public Cliente buscarPorCorreo(String correo) {
        return clienteDao.findByCorreo(correo);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteDao.findAll();
    }
}