package com.tienda_k.dao;

import com.tienda_k.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    public Usuario findByUsername(String username); 
    
}
