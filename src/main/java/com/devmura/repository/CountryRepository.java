package com.devmura.repository;

import com.devmura.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Integer>{
    Country findByName(String name);
    List<Country> findByNameLike(String pattern);

    Country findByCode(String code);
}
