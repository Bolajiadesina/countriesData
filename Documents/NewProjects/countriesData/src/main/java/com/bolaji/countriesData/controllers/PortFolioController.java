package com.bolaji.countriesData.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bolaji")

public class PortFolioController {

    @GetMapping("/portfolio")
    public String viewBooks(Model model) {
        model.addAttribute("books","Bolaji");
        return "my-portfolio";
    }
    
}
