package com.example.booklibrary.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle extends Exception {
    @ExceptionHandler(NullPointerException.class)
    public String showErrorPage(){
        return "error";
    }
//    public ExceptionHandle(String errorMessage){
//        super(errorMessage);
//    }
}
