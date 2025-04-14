package com.Titan.service;

import com.Titan.domain.Barbero;
import java.util.List;

public interface BarberoService {
    List<Barbero> listarBarberos();
    Barbero obtenerBarberoPorId(Integer id);
    void guardarBarbero(Barbero barbero);
    void eliminarBarbero(Integer id);
    boolean tieneCitasAsignadas(Integer id);


 

}