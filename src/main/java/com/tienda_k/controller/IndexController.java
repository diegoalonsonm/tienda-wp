package com.tienda_k.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("variable", "hola gente");
        model.addAttribute("edad", 25);
        
        // retorna la vista que se quiere ver
        return "index";
    }
    
    
}
