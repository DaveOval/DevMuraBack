package com.devmura.controller;

import com.devmura.entity.Country;
import com.devmura.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/country")
@CrossOrigin(origins = "*")
public class CountryController {
    @Autowired
    CountryService countryService;
    //http://localhost:8080/api/country/all
    @GetMapping
    public ResponseEntity<List<?>> getCountry(){
        return countryService.findAll();
    }
    //http://localhost:8080/api/country/save
    @PostMapping
    public ResponseEntity<?>saveCountry(@RequestBody Country country){
        return countryService.save(country);
    }
    //http://localhost:8080/api/country/delete
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return countryService.delete(id);
    }
}
