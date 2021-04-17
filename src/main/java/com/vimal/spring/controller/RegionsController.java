package com.vimal.spring.controller;

import com.vimal.spring.entity.Country;
import com.vimal.spring.entity.Locations;
import com.vimal.spring.entity.Regions;
import com.vimal.spring.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("regions/")
public class RegionsController {

    @Autowired
    private RegionsRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Regions>> getCountry(){
        List<Regions> regions = repository.findAll();
        return ResponseEntity.ok(regions);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Regions> getCountryById(@PathVariable(value = "id") Integer id){
        Optional<Regions> regionsOP = repository.findById(id);
        return ResponseEntity.ok(regionsOP.get());
    }

    @GetMapping("/{id}/country")
    public ResponseEntity<List<Country>> getCountry(@PathVariable(value = "id") Integer id){
        Optional<Regions> regionsOp = repository.findById(id);
        return ResponseEntity.ok(regionsOp.get().getCountries());
    }
}
