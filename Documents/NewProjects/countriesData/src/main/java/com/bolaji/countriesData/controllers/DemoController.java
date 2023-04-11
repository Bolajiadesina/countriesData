package com.bolaji.countriesData.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {
    @GetMapping(value ="/bolaji")
     public String bolajiPage() {  
       
      return "bolajiPortfolio";
     }

       @GetMapping(value ="/mybolajiportfolio")
     public ModelAndView bolajiPortfolio() {  

        ModelAndView md= new ModelAndView();

        md.setViewName("myportfolio");
       
      return md;
     }
}
