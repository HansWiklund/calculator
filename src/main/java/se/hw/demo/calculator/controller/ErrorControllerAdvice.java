package se.hw.demo.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorControllerAdvice {
 

    @ExceptionHandler(Exception.class) 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String generalException(final Exception e, final Model model) {
        model.addAttribute("cause", e.getClass().toString());
        model.addAttribute("message", e.getMessage());
        return "error"; 
    }
}

