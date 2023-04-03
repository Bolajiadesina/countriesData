package com.bolaji.countriesData.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CountriesByInternetUsers {
   private String  countryArea;
   private String internetUsers;
   private String population;
   private String rank;
   private String percentage;
}
