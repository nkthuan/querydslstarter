package com.credera.querydsl.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.CONFLICT )
public class InvalidBranchException extends RuntimeException {
    private static final long serialVersionUID = 7388989123109593043L;

    public InvalidBranchException(String message)
    {
        super(message);
    }
}
