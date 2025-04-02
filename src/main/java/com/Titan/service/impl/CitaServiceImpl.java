package com.Titan.service.impl;

import com.Titan.dao.CitaDao;
import com.Titan.domain.Cita;
import com.Titan.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Titan.domain.Cliente;


@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaDao citaDao;

    @Override
    public void agendarCita(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    public List<Cita> buscarCitasPorCliente(Cliente cliente) {
        return citaDao.findByCliente(cliente);
    }

    @Override
    public void cancelarCita(Integer citaId) {
        citaDao.deleteById(citaId);
    }


    @Override
    public Cita obtenerCitaPorId(Integer citaId) {
        return citaDao.findById(citaId).orElse(null);
    }



}
