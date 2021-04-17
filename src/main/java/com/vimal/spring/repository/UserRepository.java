package com.vimal.spring.repository;

import com.vimal.spring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity,Integer> {

    public UserEntity findByName(String name);
}
