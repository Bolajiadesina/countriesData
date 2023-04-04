package com.bolaji.countriesData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.bolaji.countriesData"})

public class CountriesDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesDataApplication.class, args);
	}

}
