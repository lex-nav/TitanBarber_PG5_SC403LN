package com.Titan.service.impl;

import com.Titan.dao.ServicioDao;
import com.Titan.domain.Servicio;
import com.Titan.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioDao servicioDao;

    @Override
    public List<Servicio> listarServicios() {
        return servicioDao.findAll();
    }
}