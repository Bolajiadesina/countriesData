package com.bolaji.countriesData.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolaji.countriesData.models.CountriesModel;
import com.bolaji.countriesData.repositories.CountriesRepo;




@RestController
@RequestMapping("/data")
public class CountriesController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CountriesController.class);

    private CountriesRepo repository;

    public CountriesController(CountriesRepo repository){
        this.repository= repository;
    }
    

    @GetMapping
    @ResponseBody
    @RequestMapping(value = ("/convert"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<CountriesModel> getAllCountries(){
        return repository.getAllCountries();
    }


    @GetMapping
    @ResponseBody
    @RequestMapping(value = ("/convert"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<CountriesModel> getCountriesByGDP(){
        return repository.getAllCountries();
    }

    @GetMapping
    @ResponseBody
    @RequestMapping(value = ("/convert"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<CountriesModel> getCountriesInternetUser(){
        return repository.getAllCountries();
    }
   


}
