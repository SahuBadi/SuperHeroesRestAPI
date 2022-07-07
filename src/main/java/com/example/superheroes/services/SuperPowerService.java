package com.example.superheroes.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.superheroes.exceptions.ResourceNotFoundException;
import com.example.superheroes.models.SuperPower;
import com.example.superheroes.repositories.SuperPowerRepository;

@Service
public class SuperPowerService {
	
    @Autowired
    private SuperPowerRepository superPowerRepository;
    
    public List<SuperPower> getAllSuperPowers() {
        return superPowerRepository.findAll();
    }
    
    public SuperPower getSuperPowerById(Long superPowerId) throws ResourceNotFoundException {
        SuperPower superPower = superPowerRepository.findById(superPowerId).orElseThrow(() -> new ResourceNotFoundException("superPower not found for this id :: " + superPowerId));
        return superPower;
    }
    
    public SuperPower createSuperPower(SuperPower superPower) {
        return superPowerRepository.save(superPower);
    }
    
    public SuperPower updateSuperPower(Long superPowerId, SuperPower superPowerDetails) throws ResourceNotFoundException {
        SuperPower superPower = superPowerRepository.findById(superPowerId).orElseThrow(() -> new ResourceNotFoundException("superPower not found for this id :: " + superPowerId));
        superPower.setName(superPowerDetails.getName());
        superPower.setDescription(superPowerDetails.getDescription());
        final SuperPower updatedSuperPower = superPowerRepository.save(superPower);
        return updatedSuperPower;
    }
    
    public Map<String, Boolean> deleteSuperPower(Long superPowerId) throws ResourceNotFoundException {
        SuperPower superPower = superPowerRepository.findById(superPowerId).orElseThrow(() -> new ResourceNotFoundException("superPower not found for this id :: " + superPowerId));
        superPowerRepository.delete(superPower);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
