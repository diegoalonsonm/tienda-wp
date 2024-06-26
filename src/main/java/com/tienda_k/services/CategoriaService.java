package com.tienda_k.services;

import com.tienda_k.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    // se recupera la lista de categorias en un arraylist    
    public List<Categoria> getCategorias(boolean activo);
    
    // se obtiene un registro de categorias en un objeto de tipo Categoria si el idCategoria existe
    public Categoria getCategoria(Categoria categoria);
    
    // se crea un nuevo registro en la tabla categoria si el objeto categoria no tiene idCategoria y se actualiza
    // el registro en la tabla categoria si el objeto categoria tiene un idCategoria
    public void save(Categoria categoria);
    
    // se elimina el registro en la tabla categoria si el idCategoria del objeto pasado existe en la tabla
    public void delete(Categoria categoria);
    
    
}
