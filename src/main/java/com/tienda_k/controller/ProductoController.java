package com.tienda_k.controller;

import com.tienda_k.domain.Producto;
import com.tienda_k.services.CategoriaService;
import com.tienda_k.services.FirebaseStorageService;
import com.tienda_k.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listas(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "/producto/listado";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Producto producto, @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "producto", producto.getIdProducto());
            producto.setRutaImagen(rutaImagen);
        }

        productoService.save(producto);

        return "redirect:/producto/listado";
    }

    @GetMapping("eliminar/{idProducto}")
    public String eliminar(Producto producto) {
        productoService.delete(producto);

        return "redirect:/producto/listado";
    }

    @GetMapping("modificar/{idProducto}")
    public String modificar(Producto producto, Model modelo) {
        producto = productoService.getProducto(producto);
        modelo.addAttribute("producto", producto);

        var categorias = categoriaService.getCategorias(false);
        modelo.addAttribute("categorias", categorias);

        return "/producto/modifica";
    }

}
