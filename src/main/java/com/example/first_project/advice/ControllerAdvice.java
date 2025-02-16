package com.example.first_project.advice;

import com.example.first_project.DTO.ErrorDto;
import com.example.first_project.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(){
        ErrorDto errorDto = new ErrorDto(); //object of errorDto
        errorDto.setErrorCode("400");
        errorDto.setErrorMsg("Bad Request");

        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(){
        ErrorDto errorDto = new ErrorDto(); //object of errorDto
        errorDto.setErrorCode("405");
        errorDto.setErrorMsg("product not found");

        return ResponseEntity.badRequest().body(errorDto);
    }
}
