package com.tienda_k.services;

import com.tienda_k.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    // se recupera la lista de categorias en un arraylist    
    public List<Categoria> getCategorias(boolean activo);
    
}
