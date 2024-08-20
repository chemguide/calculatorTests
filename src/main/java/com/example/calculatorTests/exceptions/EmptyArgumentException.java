package com.example.calculatorTests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyArgumentException extends RuntimeException {
    public EmptyArgumentException(){
        super();
    }
}
