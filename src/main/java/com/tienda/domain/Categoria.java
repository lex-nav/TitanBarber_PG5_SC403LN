
package com.tienda.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Data
@Entity
@Table(Name="Categoria")
public class Categoria implements Serializable{
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private long idCategoria;
    
    
    private String Descripcion;
    
    @Column(name="ruta_imagen")
    private Srting RutaImagen;
    
    
    private Boolean Activo
            
public Categoria(){

}

public Categoria(String descripcion, boolean activo){
    this.descripcion = descripcion;
    this.activo = activo;
}

}
