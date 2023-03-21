package com.example.emtlab1.service;

import com.example.emtlab1.model.Country;

import java.util.List;
import java.util.Optional;


public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);
}
