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
import com.example.superheroes.models.SuperPower;
import com.example.superheroes.services.SuperPowerService;

@RestController
@RequestMapping("/api")
public class SuperPowerController {
	
    @Autowired
    private SuperPowerService superPowerService;

    @GetMapping("/superpowers")
    public List<SuperPower> getAllSuperPowers() {
        return superPowerService.getAllSuperPowers();
    }

    @GetMapping("/superpowers/{id}")
    public SuperPower getSuperPowerById(@PathVariable(value = "id") Long superPowerId) throws ResourceNotFoundException {
        return superPowerService.getSuperPowerById(superPowerId);
    }

    @PostMapping("/superpowers")
    public SuperPower createSuperPower(@Validated @RequestBody SuperPower superPower) {
        return superPowerService.createSuperPower(superPower);
    }

    @PutMapping("/superpowers/{id}")
    public SuperPower updateSuperPower(@PathVariable(value = "id") Long superPowerId, @Validated @RequestBody SuperPower superPowerDetails) throws ResourceNotFoundException {
        return superPowerService.updateSuperPower(superPowerId, superPowerDetails);
    }

    @DeleteMapping("/superpowers/{id}")
    public Map<String, Boolean> deleteSuperPower(@PathVariable(value = "id") Long superPowerId) throws ResourceNotFoundException {
        return superPowerService.deleteSuperPower(superPowerId);
    }


}
