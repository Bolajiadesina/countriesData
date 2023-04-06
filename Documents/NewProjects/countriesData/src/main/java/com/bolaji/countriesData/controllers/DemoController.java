package com.bolaji.countriesData.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class DemoController {
    @RequestMapping(value ="/portfolio")
     public String bolajiPage() {  
        
      return "thymeleafTemplate";
   
     }
}
