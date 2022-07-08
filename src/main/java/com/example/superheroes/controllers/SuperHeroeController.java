package com.example.superheroes.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.superheroes.exceptions.ResourceNotFoundException;
import com.example.superheroes.models.SuperHeroe;
import com.example.superheroes.services.SuperHeroeService;

@RestController
@RequestMapping("/api")
public class SuperHeroeController {
	
    @Autowired
    private SuperHeroeService superHeroeService;
    
    @GetMapping("/superheroes")
    public List<SuperHeroe> getAllSuperHeroes() {
        return superHeroeService.findAll();
    }

    @GetMapping("/superheroes/{id}")
    public SuperHeroe getSuperHeroeById(@PathVariable(value = "id") Long superHeroeId) throws ResourceNotFoundException {
        return superHeroeService.findById(superHeroeId);
    }

    @PostMapping("/superheroes")
    public SuperHeroe createSuperHeroe(@Validated @RequestBody SuperHeroe superHeroe) {
        return superHeroeService.createSuperHeroe(superHeroe);

    }

    @PutMapping("/superheroes/{id}")
    public SuperHeroe updateSuperHeroe(@PathVariable(value = "id") Long superHeroeId, @Validated @RequestBody SuperHeroe superHeroeDetails) throws ResourceNotFoundException {
        return superHeroeService.updateSuperHeroe(superHeroeId, superHeroeDetails);
    }
    
    @PutMapping("/superheroes/kill/{id}")
    public SuperHeroe killSuperHeroe(@PathVariable(value = "id") Long superHeroeId) throws ResourceNotFoundException {
        return superHeroeService.killSuperHeroe(superHeroeId);
    }
    
    @PutMapping("/superheroes/revive/{id}")
    public SuperHeroe reviveSuperHeroe(@PathVariable(value = "id") Long superHeroeId) throws ResourceNotFoundException {
        return superHeroeService.reviveSuperHeroe(superHeroeId);
    }        

    @DeleteMapping("/superheroes/{id}")
    public Map<String, Boolean> deleteSuperHeroe(@PathVariable(value = "id") Long superHeroeId) throws ResourceNotFoundException {
        return superHeroeService.deleteSuperHeroe(superHeroeId);
    }

}
