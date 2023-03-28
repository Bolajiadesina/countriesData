package com.portfolio.bolaji.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String BAD_REQUEST = "BAD_REQUEST";
    private static final String ERROR = "ERROR";
    private static final String API_PROCESSING_ERROR = null;
    private static final String INVALID_REQUEST  ="INVALID_REQUEST" ;
    private static final String SERVICE_UNAVAILABLE  = "SERVICE_UNAVAILABLE";
    private static final String RECORD_NOT_FOUND = "RECORD_NOT_FOUND" ;
    private static final String INVALID_HEADER_VALUES = "INVALID_HEADER_VALUES" ;
    private final ResponseUtils responseUtils;


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid (final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        logger.info(ex.getClass().getName());
        final List<String> errors = new ArrayList<String>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final ErrorResponse apiError = new ErrorResponse("Validation Failed", errors, HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ErrorResponse apiError = new ErrorResponse("Validation Failed", Arrays.asList(ex.getMessage()), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }


    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<Object> handleUnrecognizedPropertyException (UnrecognizedPropertyException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ErrorResponse apiError = new ErrorResponse("Unrecognized Field Value", Arrays.asList(ex.getMessage()), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, apiError, headers,status, request);
    }


    @ExceptionHandler({CountriesExceptions.class})
    public ResponseEntity<ResponseUtils<Object>> handleNrhException(CountriesExceptions ex){

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ResponseUtils<Object> utilsResponse = new ResponseUtils<>()
                .setResponseCode(ex.getCode())
                .setResponseMessage(ex.getMessage());
        
        if (Objects.isNull(ex.getResponseEnum())) return ResponseEntity.ok(utilsResponse);


        switch (ex.getResponseEnum()){
            case INVALID_REQUEST:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
           
            case RECORD_NOT_FOUND:
                httpStatus = HttpStatus.NOT_FOUND;
                break;
            case INVALID_HEADER_VALUES:
                httpStatus = HttpStatus.UNAUTHORIZED;
                break;
            case SERVICE_UNAVAILABLE:
                httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
                break;
            case ERROR:
            case API_PROCESSING_ERROR:
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            default:
            	httpStatus = HttpStatus.OK;
            	break;
        }


        return ResponseEntity.status(httpStatus).body(utilsResponse);
    }
}
