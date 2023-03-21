package com.example.emtlab1.service;

import com.example.emtlab1.model.Author;

import java.util.List;
import java.util.Optional;


public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);
}
