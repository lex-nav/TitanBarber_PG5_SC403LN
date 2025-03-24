package com.Titan.service;

import com.Titan.domain.Barbero;
import java.util.List;

public interface BarberoService {
    List<Barbero> listarBarberos();
    void guardarBarbero(Barbero barbero);
}