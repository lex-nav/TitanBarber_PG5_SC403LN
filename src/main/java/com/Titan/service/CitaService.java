package com.Titan.service;

import com.Titan.domain.Cita;
import java.util.List;

public interface CitaService {
    void agendarCita(Cita cita);
    List<Cita> listarCitasPorCliente(Integer clienteId);
}