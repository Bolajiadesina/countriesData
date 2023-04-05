package com.bolaji.countriesData.controllers;


import org.springframework.beans.factory.annotation.Autowired;
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
   
   
    @Autowired
     private CountriesRepo countryRepo;
    
  
    public CountriesController(CountriesRepo countryRepo){
        this.countryRepo= countryRepo;
    }
    
  
    @GetMapping
    @ResponseBody
    @RequestMapping(value = ("/getAllCountries"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<ResponseUtils> getAllCountries(){
        return countryRepo.getAllCountries();
    }


    @PostMapping
    @ResponseBody
    @RequestMapping(value = ("/getCountriesByGDP"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<ResponseUtils> getCountriesByGDP(@RequestBody  CountryRequest   request ){
        logger.info("request {}", request);
        return countryRepo.getCountriesByGDP(request);
    }
  
    @PostMapping
    @ResponseBody
    @RequestMapping(value = ("/getCountriesInternetUser"), method = { RequestMethod.POST }, produces = {
        "application/json" }, consumes = { "application/json" })
    public ResponseEntity<ResponseUtils> getCountriesInternetUser(@RequestBody  CountryRequest   request ){
        return countryRepo.getCountriesInternetUser(request);
    }
   
}
