package com.bolaji.countriesData.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bolaji.countriesData.models.CountriesModel;



@Service
public class CountriesRepoImpl  implements CountriesRepo {
    private static Logger logger = LoggerFactory.getLogger(CountriesRepoImpl.class);
    @Override
    public ResponseEntity<CountriesModel> getAllCountries() {
        // TODO Auto-generated method stub

        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }



        throw new UnsupportedOperationException("Unimplemented method 'getAllCountries'");
    }

    @Override
    public CountriesModel getCountriesByGdpComposition(String gdpComposition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCountriesByGdpComposition'");
    }

    @Override
    public CountriesModel getCountriesByNumOfInternetUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCountriesByNumOfInternetUser'");
    }
    
}