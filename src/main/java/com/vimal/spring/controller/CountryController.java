package com.vimal.spring.controller;

import com.vimal.spring.entity.Country;
import com.vimal.spring.entity.Locations;
import com.vimal.spring.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/")
    public ResponseEntity<List<Country>> getCountry(){
        List<Country> countries = countryRepository.findAll();
      return ResponseEntity.ok(countries);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") String id){
        Optional<Country> countryOP = countryRepository.findById(id);
        return ResponseEntity.ok(countryOP.get());
    }
    @GetMapping("/{id}/locations")
    public ResponseEntity<List<Locations>> getCountryLocaions(@PathVariable(value = "id") String id){
        Optional<Country> countryOP = countryRepository.findById(id);
        return ResponseEntity.ok(countryOP.get().getLocations());
    }
}
