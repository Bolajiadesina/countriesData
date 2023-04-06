package com.bolaji.countriesData.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {
    @RequestMapping(value ="/bolaji")
     public String bolajiPage() {  
        
      return "bolaji";
   
     }
}
