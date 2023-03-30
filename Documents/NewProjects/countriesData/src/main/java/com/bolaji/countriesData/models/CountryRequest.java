package com.bolaji.countriesData.models;

import javax.validation.constraints.NotEmpty;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CountryRequest {


    @NotEmpty(message = "The field country cannot be empty")
    private String country;
    private String countryCode;
   

    
}