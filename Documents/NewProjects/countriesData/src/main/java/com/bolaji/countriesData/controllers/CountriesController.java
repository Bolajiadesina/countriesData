package com.bolaji.countriesData.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolaji.countriesData.models.CountriesModel;
import com.bolaji.countriesData.repositories.CountriesRepo;

public class CountriesController {


    private CountriesRepo repository;

    public CountriesController(CountriesRepo repository){
        this.repository= repository;

    }
    

    @GetMapping
    @ResponseBody
    public ResponseEntity<CountriesModel> getAllCountries(){
        return repository.getAllCountries();
    }




}
