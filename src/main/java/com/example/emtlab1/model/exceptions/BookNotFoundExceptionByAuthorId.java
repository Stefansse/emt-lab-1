package com.example.emtlab1.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNotFoundExceptionByAuthorId extends RuntimeException {
    public BookNotFoundExceptionByAuthorId(Long id){
        super(String.format("Book with author id: %d does not exist", id));
    }
}
