package com.example.superheroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.superheroes.models.SuperHeroe;

@Repository
public interface SuperHeroeRepository extends JpaRepository<SuperHeroe, Long> {

}
