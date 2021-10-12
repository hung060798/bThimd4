package com.codegym.service;

import com.codegym.model.Cities;

import java.util.Optional;


public interface ICityService {
    Cities save(Cities city);
    Iterable<Cities> findAll();
    Optional<Cities> findById(Long id);
    void delete(Long id);
}
