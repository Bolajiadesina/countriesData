package com.bolaji.countriesData.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bolaji")

public class PortFolioController {

    @RequestMapping(value ="/portfolio", method = RequestMethod.GET)
   // @ExceptionHandler(value = PortFolioController.class)
    public ModelAndView myPage() {    
        final ModelAndView modelAndView = new ModelAndView("my-portfolio");   
        return modelAndView;
    }
    
}
