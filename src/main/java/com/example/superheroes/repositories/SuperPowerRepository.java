package com.example.superheroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.superheroes.models.SuperPower;

@Repository
public interface SuperPowerRepository extends JpaRepository<SuperPower, Long>{
    SuperPower findByName(String name);
}
