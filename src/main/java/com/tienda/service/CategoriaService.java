
package com.tienda.service;
import java.util.list;
import com.tienda.domain.Categoria;

public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activos);
}
