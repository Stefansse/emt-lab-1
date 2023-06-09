package com.example.emtlab1.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNoMoreCopiesException extends RuntimeException {
    public BookNoMoreCopiesException(String text){
        super(text);
    }
}
