package com.Titan.service.impl;

import com.Titan.dao.BarberoDao;
import com.Titan.domain.Barbero;
import com.Titan.service.BarberoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
