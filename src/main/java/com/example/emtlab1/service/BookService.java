package com.example.emtlab1.service;

import com.example.emtlab1.model.Author;
import com.example.emtlab1.model.Book;
import com.example.emtlab1.model.Category;
import com.example.emtlab1.model.dto.BookDto;

import java.util.List;
import java.util.Optional;


public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> addBook(String name, Category category, Author author, Integer availableCopies);


    void deleteById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> markAsTaken(Long id);

    Optional<Book> leastUsed(Long id);
}
