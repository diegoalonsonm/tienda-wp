package com.tienda_k.controller;

import com.tienda_k.domain.Producto;
import com.tienda_k.services.CategoriaService;
import com.tienda_k.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listas(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "/pruebas/listado";
    }

    @GetMapping("modificar/{idProducto}")
    public String modificar(Producto producto, Model modelo) {
        producto = productoService.getProducto(producto);
        modelo.addAttribute("producto", producto);

        var categorias = categoriaService.getCategorias(false);
        modelo.addAttribute("categorias", categorias);

        return "/pruebas/modifica";
    }

}
