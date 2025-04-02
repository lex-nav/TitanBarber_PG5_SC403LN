package com.Titan.service;

import com.Titan.domain.Cita;
import com.Titan.domain.Cliente;

import java.util.List;

public interface CitaService {
    void agendarCita(Cita cita);
    List<Cita> buscarCitasPorCliente(Cliente cliente);
    void cancelarCita(Integer citaId);

    Cita obtenerCitaPorId(Integer id);
}