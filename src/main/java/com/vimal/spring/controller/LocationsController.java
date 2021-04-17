package com.vimal.spring.controller;

import com.vimal.spring.entity.Locations;
import com.vimal.spring.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
@Slf4j
public class LocationsController {

    @Autowired
    LocationRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Locations>> getLocations(){
        List<Locations> locations = repository.findAll();
        return ResponseEntity.ok(locations);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Locations> getLocationsById(@PathVariable(value = "id") Integer id){
        Optional<Locations> locationOP = repository.findById(id);
        return ResponseEntity.ok(locationOP.get());
    }

    @PostMapping("/save")
    public ResponseEntity<Locations> saveLocations(@RequestBody Locations locations){
        log.info("Getting mridul {}",locations);
        repository.save(locations);
        return ResponseEntity.ok(locations);
    }
}
