package com.devmura.repository;

import com.devmura.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>{
    Country findByName(String name);
    List<Country> findByNameLike(String pattern);

    Country findByCode(String code);
}
