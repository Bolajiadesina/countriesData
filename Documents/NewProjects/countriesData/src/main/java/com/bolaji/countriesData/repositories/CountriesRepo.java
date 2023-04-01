package com.bolaji.countriesData.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bolaji.countriesData.models.CountriesModel;
import com.bolaji.countriesData.models.CountryRequest;
import com.bolaji.countriesData.models.ResponseUtils;



@Service
public interface CountriesRepo {

    public ResponseEntity<ResponseUtils>  getAllCountries();
    public ResponseEntity<CountriesModel> getCountriesByGDP(CountryRequest request);
    public ResponseEntity<CountriesModel> getCountriesInternetUser(CountryRequest request);
    
}
