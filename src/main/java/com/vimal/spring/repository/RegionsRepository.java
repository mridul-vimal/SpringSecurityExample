package com.vimal.spring.repository;

import com.vimal.spring.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegionsRepository extends JpaRepository<Regions,Integer> {
}
