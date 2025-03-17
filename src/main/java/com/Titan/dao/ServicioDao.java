package com.Titan.dao;

import com.Titan.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioDao extends JpaRepository<Servicio, Integer> {
}
