package com.bolaji.countriesData.exceptions;

import org.springframework.stereotype.Service;

@Service
public class CountriesExceptions {
    

    private ResponseEnum responseEnum;
    private String message;
    private String code;

    public CountriesExceptions(ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.responseEnum = responseEnum;
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }
    
    public CountriesExceptions(ResponseEnum responseEnum, String message) {
        super((!StringUtils.isEmptyBlank(message)) ? message : responseEnum.getMessage());
        this.responseEnum = responseEnum;
        this.code = responseEnum.getCode();
        this.message = (!StringUtils.isEmptyBlank(message) ? message : responseEnum.getMessage());
    }
    
    public CountriesExceptions(String code, String message) {
        super(message);
        this.code = code;;
        this.message = message;
    }
}