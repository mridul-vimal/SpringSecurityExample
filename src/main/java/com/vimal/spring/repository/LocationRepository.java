package com.vimal.spring.repository;


import com.vimal.spring.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Locations,Integer> {

}
