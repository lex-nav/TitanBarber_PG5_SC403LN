package com.Titan.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "barberos")
public class Barbero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String especialidad;

   
    public Barbero() {}

    public Barbero(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
