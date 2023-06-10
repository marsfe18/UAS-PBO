package com.marsay.kantinstis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequstException extends RuntimeException {
    public BadRequstException(String message) {
        super(message);
    }
}
