package com.tienda_k.dao;

import com.tienda_k.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    public Usuario findByUsername(String username); 
    
    public Usuario findByUsernameAndPassword(String username, String Password);

    public Usuario findByUsernameOrCorreo(String username, String correo);

    public boolean existsByUsernameOrCorreo(String username, String correo);  
    
}