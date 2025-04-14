package com.Titan.service.impl;

import com.Titan.dao.BarberoDao;
import com.Titan.domain.Barbero;
import com.Titan.service.BarberoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Titan.dao.CitaDao;

@Service
public class BarberoServiceImpl implements BarberoService {

    @Autowired
    private BarberoDao barberoDao;

    @Override
    public List<Barbero> listarBarberos() {
        return barberoDao.findAll();
    }

    @Override
    public void guardarBarbero(Barbero barbero) {
        barberoDao.save(barbero);
    }
    
    @Override
    public Barbero obtenerBarberoPorId(Integer id) {
        return barberoDao.findById(id).orElse(null);
    }

    @Autowired
    private CitaDao citaDao;

    @Override
    public boolean tieneCitasAsignadas(Integer id) {
        return !citaDao.findByBarberoId(id).isEmpty();
    }

    
   @Override
    public void eliminarBarbero(Integer id) {
        barberoDao.deleteById(id);
    }
   
}
