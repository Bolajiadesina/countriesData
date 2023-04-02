package com.bolaji.countriesData.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bolaji.countriesData.models.CountryRequest;
import com.bolaji.countriesData.models.ResponseUtils;
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
    @RequestMapping(value = ("/getAllCountries"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<ResponseUtils> getAllCountries(){
        return repository.getAllCountries();
    }


    @PostMapping
    @ResponseBody
    @RequestMapping(value = ("/getCountriesByGDP"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<ResponseUtils> getCountriesByGDP(@RequestBody  CountryRequest   request ){
        logger.info("request {}", request);
        return repository.getCountriesByGDP(request);
    }
  
    @PostMapping
    @ResponseBody
    @RequestMapping(value = ("/getCountriesInternetUser"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<ResponseUtils> getCountriesInternetUser(@RequestBody  CountryRequest   request ){
        return repository.getCountriesInternetUser(request);
    }
   


}
