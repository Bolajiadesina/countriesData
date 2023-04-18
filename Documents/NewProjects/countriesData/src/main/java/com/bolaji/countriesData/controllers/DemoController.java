package com.bolaji.countriesData.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {
    @GetMapping("/bolaji")
     public String bolajiPage(Model model) {  
      model.addAttribute("ListOfThreeProducts","products");
      return "bolajiPortfolio";
     }

       @GetMapping("/mybolajiportfolio")
     public ModelAndView bolajiPortfolio() {  

        ModelAndView md= new ModelAndView();

        md.setViewName("myportfolio");
       
      return md;
     }

     @RequestMapping(value="/do-stuff")
public void doStuffMethod() {
    System.out.println("Success");
}
}
