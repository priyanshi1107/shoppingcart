package com.assignment.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(value= ProductsNotFoundException.class)
    public String ProductsNotFoundExceptionHandler(Model model){
        model.addAttribute("msg","Products not found in database");
        return "product-not-found";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class)
    public String BadRequestExceptionHandler(Model model){
        model.addAttribute("msg","Bad Request" );
        return "The Product Name Is Not Valid";
    }
}
