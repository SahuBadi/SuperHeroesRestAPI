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
import com.example.superheroes.models.Universe;
import com.example.superheroes.services.UniverseService;

@RestController
@RequestMapping("/api")
public class UniverseController {
	
    @Autowired
    private UniverseService universeService;
    
    @GetMapping("/universes")
    public List<Universe> getAllUniverses() {
        return universeService.findAll();
    }

    @GetMapping("/universes/{id}")
    public Universe getUniverseById(@PathVariable(value = "id") Long universeId) throws ResourceNotFoundException {
        return universeService.getUniverseById(universeId);
    }

    @PostMapping("/universes")
    public Universe createUniverse(@Validated @RequestBody Universe universe) {
        return universeService.createUniverse(universe);
    }

    @PutMapping("/universes/{id}")
    public Universe updateUniverse(@PathVariable(value = "id") Long universeId, @Validated @RequestBody Universe universeDetails) throws ResourceNotFoundException {
        return universeService.updateUniverse(universeId, universeDetails);
    }

    @DeleteMapping("/universes/{id}")
    public Map<String, Boolean> deleteUniverse(@PathVariable(value = "id") Long universeId) throws ResourceNotFoundException {
        return universeService.deleteUniverse(universeId);
    }

}
