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
    @GetMapping("/all")
    public ResponseEntity<List<Country>> getCountry(){
        List<Country> country = countryService.getAll();
        return ResponseEntity.ok(country);
    }
    //http://localhost:8080/api/country/save
    @PostMapping("/save")
    public ResponseEntity<Void>saveCountry(@RequestBody Country country){
        countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //http://localhost:8080/api/country/delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        countryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
