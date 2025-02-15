package com.SkyHire.project.ExceptionHandle;


import com.SkyHire.project.Utility.ApiErrorResponse;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(ResourceNotFoundException ex){

        ApiErrorResponse response= new ApiErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> notValidException(MethodArgumentNotValidException ex){

        ApiErrorResponse response=new ApiErrorResponse(HttpStatus.BAD_REQUEST,ex.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidInput(InvalidInputException ex){

        ApiErrorResponse response=new ApiErrorResponse(HttpStatus.BAD_REQUEST,ex.getMessage(),LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
