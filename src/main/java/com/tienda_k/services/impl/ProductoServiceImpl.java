package com.tienda_k.services.impl;

import com.tienda_k.dao.ProductoDao;
import com.tienda_k.domain.Producto;
import java.util.List;
import com.tienda_k.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var lista = productoDao.findAll();

        if (activo) {
            lista.removeIf(prod -> !prod.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
       productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    @Override
    @Transactional
    public List<Producto> consulta1(double precioInferior, double precioSuperior) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInferior, precioSuperior);
    }

    @Override
    @Transactional
    public List<Producto> consulta2(int cantidad) {
        return productoDao.findByExistencias(cantidad);
    }

}
