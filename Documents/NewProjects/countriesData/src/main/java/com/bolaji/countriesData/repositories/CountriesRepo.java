package com.bolaji.countriesData.repositories;

import org.springframework.http.ResponseEntity;

import com.bolaji.countriesData.models.CountriesModel;

public interface CountriesRepo {

    public ResponseEntity<CountriesModel>  getAllCountries();
    public CountriesModel getCountriesByGdpComposition( String gdpComposition);
    public CountriesModel  getCountriesByNumOfInternetUser();
    
}
