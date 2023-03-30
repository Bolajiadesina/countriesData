package com.bolaji.countriesData.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

   // private final ResponseUtils responseUtils;


    // @Override
    // protected ResponseEntity<Object> handleMethodArgumentNotValid (final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
    //     logger.info(ex.getClass().getName());
    //     final List<String> errors = new ArrayList<String>();
    //     for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
    //         errors.add(error.getField() + ": " + error.getDefaultMessage());
    //     }
    //     for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
    //         errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
    //     }
    //     final ErrorResponse apiError = new ErrorResponse("Validation Failed", errors, HttpStatus.BAD_REQUEST.value());
    //     return handleExceptionInternal(ex, apiError, headers, status, request);
    // }

    // @Override
    // public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    //     final ErrorResponse apiError = new ErrorResponse("Validation Failed", Arrays.asList(ex.getMessage()), HttpStatus.BAD_REQUEST.value());
    //     return handleExceptionInternal(ex, apiError, headers, status, request);
    // }


    // @ExceptionHandler(UnrecognizedPropertyException.class)
    // public ResponseEntity<Object> handleUnrecognizedPropertyException (UnrecognizedPropertyException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    //     final ErrorResponse apiError = new ErrorResponse("Unrecognized Field Value", Arrays.asList(ex.getMessage()), HttpStatus.BAD_REQUEST.value());
    //     return handleExceptionInternal(ex, apiError, headers,status, request);
    // }


    // @ExceptionHandler({CountriesExceptions.class})
    // public ResponseEntity<ResponseUtils<Object>> handleNrhException(CountriesExceptions ex){

    //     HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    //     ResponseUtils<Object> utilsResponse = new ResponseUtils<>()
    //             .setResponseCode(ex.getCode())
    //             .setResponseMessage(ex.getMessage());
        
    //     if (Objects.isNull(ex.getResponseEnum())) return ResponseEntity.ok(utilsResponse);


    //     switch (ex.getResponseEnum()){
    //         case INVALID_REQUEST:
    //             httpStatus = HttpStatus.BAD_REQUEST;
    //             break;
           
    //         case RECORD_NOT_FOUND:
    //             httpStatus = HttpStatus.NOT_FOUND;
    //             break;
    //         case INVALID_HEADER_VALUES:
    //             httpStatus = HttpStatus.UNAUTHORIZED;
    //             break;
    //         case SERVICE_UNAVAILABLE:
    //             httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
    //             break;
    //         case ERROR:
    //         case API_PROCESSING_ERROR:
    //             httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    //             break;
    //         default:
    //         	httpStatus = HttpStatus.OK;
    //         	break;
    //     }


    //     return ResponseEntity.status(httpStatus).body(utilsResponse);
    // }
}
