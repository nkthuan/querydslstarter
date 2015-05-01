package com.credera.querydsl.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class BranchNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 6798538651671463342L;


    public BranchNotFoundException(String message) {
        super(message);
    }
}
