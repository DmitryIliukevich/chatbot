package com.example.repository;


import com.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT t.brand FROM City t where t.name = :name")
    String findBrand(@Param("name") String name);
}

