package com.tienda_k.controller;

import com.tienda_k.domain.Producto;
import com.tienda_k.domain.Categoria;
import com.tienda_k.services.CategoriaService;
import com.tienda_k.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/listado/{idCategoria}")
    public String modificar(Categoria categoria, Model modelo) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        modelo.addAttribute("productos", productos);

        var categorias = categoriaService.getCategorias(false);
        modelo.addAttribute("categorias", categorias);

        return "/pruebas/listado";
    }
    
    @GetMapping("/listado2")
    public String listas2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);

        return "/pruebas/listado2";
    }
    
    @PostMapping("/consulta1")
    public String consulta1(@RequestParam(value="precioInferior") double precioInferior,
            @RequestParam(value="precioSuperior") double precioSuperior,Model model) {
        
        var productos = productoService.consulta1(precioInferior, precioSuperior);
        model.addAttribute("precioInferior", precioInferior);
        model.addAttribute("precioSuperior", precioSuperior);
        model.addAttribute("productos", productos);

        return "/pruebas/listado2";
    }

    @PostMapping("/consulta2")
    public String consulta2(@RequestParam(value="stockMinimo") int cantidad,Model model) {
        var productos = productoService.consulta2(cantidad);
        model.addAttribute("cantidad", cantidad);
        model.addAttribute("productos", productos);

        return "/pruebas/listado2";
    }

}
