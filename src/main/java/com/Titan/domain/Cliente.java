package com.Titan.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String contraseña;
    private String rol = "cliente";

    
    public Cliente() {}

    public Cliente(String nombre, String apellido, String correo, String telefono, String contraseña, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.rol = "cliente";
    }

    
    public Integer getId() { 
        return id; 
    }
    public void setId(Integer id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    public String getApellido() { 
        return apellido; 
    }
    public void setApellido(String apellido) { 
        this.apellido = apellido; 
    }

    public String getCorreo() { 
        return correo; 
    }
    public void setCorreo(String correo) { 
        this.correo = correo; 
    }

    public String getTelefono() { 
        return telefono; 
    }
    public void setTelefono(String telefono) { 
        this.telefono = telefono; 
    }

    public String getContraseña() { 
        return contraseña; 
    }
    public void setContraseña(String contraseña) { 
        this.contraseña = contraseña; 
    }
    
    public String getRol() {
    return rol;
    }
    public void setRol(String rol) {
    this.rol = rol;
    }


}