package com.happiest.apigateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT) // HTTP 409
public class UserAlreadyPresentException extends RuntimeException {

    public UserAlreadyPresentException() {
        super("User already exists");
    }
}

