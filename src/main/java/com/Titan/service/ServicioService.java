package com.Titan.service;

import com.Titan.domain.Servicio;
import java.util.List;

public interface ServicioService {
    List<Servicio> listarServicios();
    void guardarServicio(Servicio servicio); // ✅ Agregamos este método
}