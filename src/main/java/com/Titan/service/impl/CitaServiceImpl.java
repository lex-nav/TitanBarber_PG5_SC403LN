package com.Titan.service.impl;

import com.Titan.dao.CitaDao;
import com.Titan.domain.Cita;
import com.Titan.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaDao citaDao;

    @Override
    public void agendarCita(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    public List<Cita> listarCitasPorCliente(Integer clienteId) {
        return citaDao.findByClienteId(clienteId);
    }
}
