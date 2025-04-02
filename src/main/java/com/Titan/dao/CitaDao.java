package com.Titan.dao;

import com.Titan.domain.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.Titan.domain.Cliente;

@Repository
public interface CitaDao extends JpaRepository<Cita, Integer> {
    List<Cita> findByClienteId(Integer clienteId);
    List<Cita> findByCliente(Cliente cliente);
}