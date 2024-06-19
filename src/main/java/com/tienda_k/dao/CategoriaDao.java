package com.tienda_k.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda_k.domain.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    
}
