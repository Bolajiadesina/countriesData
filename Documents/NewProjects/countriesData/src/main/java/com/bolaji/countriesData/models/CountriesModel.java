package com.bolaji.countriesData.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CountriesModel {
    private int rank;
    private String country;
    private String dependency;
    private String continent;
    private Double population;
    private Date  date;
    private String source;

    
}
