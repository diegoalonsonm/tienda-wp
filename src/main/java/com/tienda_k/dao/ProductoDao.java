package com.tienda_k.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda_k.domain.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long> {

}