package com.tienda_k.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda_k.domain.Producto;
import java.util.List;

public interface ProductoDao extends JpaRepository<Producto, Long> {

    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInferior, double precioSuperior);
    
}