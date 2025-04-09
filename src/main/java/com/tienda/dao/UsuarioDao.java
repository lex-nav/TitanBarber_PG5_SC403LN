package com.tienda.dao;

import com.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
    
    @Query("SELECT u.username, COUNT(f) FROM Usuario u LEFT JOIN Factura f ON f.usuario.idUsuario = u.idUsuario GROUP BY u.username")
    List<Object[]> contarFacturasPorUsuario();

}
