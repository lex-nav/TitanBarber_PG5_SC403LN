package com.Titan.service;

import com.Titan.dao.ClienteDao;
import com.Titan.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ClienteDetailsService implements UserDetailsService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Cliente cliente = clienteDao.findByCorreo(correo);
        if (cliente == null) {
            throw new UsernameNotFoundException("Correo no encontrado: " + correo);
        }
        
        return new User(
                cliente.getCorreo(),
                cliente.getContraseña(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + cliente.getRol()))
        );
    }
    

}