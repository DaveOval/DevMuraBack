package com.devmura.repository;

import com.devmura.entity.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("devmura")
class CountryRepositoryTest {
    @Autowired
    CountryRepository countryRepository;

    @Test
    public void testFindAll() {
        Iterable<Country> iterable = countryRepository.findAll();
        iterable.forEach(System.out::println);
    }

    @Test
    public void findById() {
        Integer Id = 1;
        Country country = countryRepository.findById(Id).get();
        System.out.println(country);
        assertEquals(Id, country.getId());
    }

    @Test
    public void saveCountry(){
        Country country = new Country();
        country.setName("Colombia");

        List<Country> listCountry = countryRepository.findAll();



        System.out.println(listCountry.contains(country.getName()));
        System.out.println(country.getName());

        listCountry.forEach((pais) -> System.out.println(pais.getName()));


//        if(!(listCountry.contains(country.getName())))
//        {
//            countryRepository.save(country);
//            System.out.println(country);
//            assertNotNull(country.getId());
//        }

    }

    @Test
    public void findCountryByName(){
        String name = "México";
        Country country = countryRepository.findByName(name);
        System.out.println(country);
        assertEquals(name,country.getName());
    }

    @Test
    public void deleteCountryById(){
        Integer id = 4;

        Optional<Country> optional = countryRepository.findById(id);
        if (optional.isPresent()){
            countryRepository.deleteById(id);
        }

        assertNotEquals(id,optional);
    }

    @Test
    public void findCountryLike() {
        System.out.println("Countries with 'C' in first position");
        countryRepository.findByNameLike("c%").forEach(System.out::println);

        System.out.println("Countries with 'a' in any position");
        countryRepository.findByNameLike("%a%").forEach(System.out::println);
    }


}