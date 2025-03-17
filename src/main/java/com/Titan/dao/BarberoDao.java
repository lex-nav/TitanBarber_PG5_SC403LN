package com.Titan.dao;

import com.Titan.domain.Barbero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberoDao extends JpaRepository<Barbero, Integer> {
}
