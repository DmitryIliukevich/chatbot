package com.example.service;

import java.util.List;

import com.example.model.City;
import com.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityService {

    @Autowired
    private CityRepository repo;

    public List<City> listAll() {
        return repo.findAll();
    }

    public void save(City city) {
        repo.save(city);
    }

    public City get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public String findBrand(String name) {
        return repo.findBrand(name);
    }
}
