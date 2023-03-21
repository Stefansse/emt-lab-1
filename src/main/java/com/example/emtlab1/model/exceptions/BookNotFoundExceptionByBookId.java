package com.example.emtlab1.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNotFoundExceptionByBookId extends RuntimeException {
    public BookNotFoundExceptionByBookId(Long id) {
        super(String.format("Book with id:%d does not exist", id));
    }
}
