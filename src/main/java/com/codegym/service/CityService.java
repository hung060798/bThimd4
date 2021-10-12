package com.codegym.service;

import com.codegym.model.Cities;
import com.codegym.repository.ICityRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    ICityRepo cityRepo;
    @Override
    public Cities save(Cities city) {
        return cityRepo.save(city);
    }

    @Override
    public Iterable<Cities> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional<Cities> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        cityRepo.deleteById(id);
    }
}
