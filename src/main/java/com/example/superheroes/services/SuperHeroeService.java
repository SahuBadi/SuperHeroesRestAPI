package com.example.superheroes.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.superheroes.exceptions.ResourceNotFoundException;
import com.example.superheroes.models.SuperHeroe;
import com.example.superheroes.models.SuperPower;
import com.example.superheroes.models.Universe;
import com.example.superheroes.repositories.SuperHeroeRepository;
import com.example.superheroes.repositories.SuperPowerRepository;
import com.example.superheroes.repositories.UniverseRepository;

@Service
public class SuperHeroeService {

    @Autowired
    private UniverseRepository universeRepository;
    @Autowired
    private SuperHeroeRepository superHeroeRepository;
    @Autowired
    private SuperPowerRepository superPowerRepository;
    
    public SuperHeroe createSuperHeroe(SuperHeroe superHeroe) {
        Universe foundUniverse = universeRepository.findByName(superHeroe.getUniverse().getName());
        if (foundUniverse != null) {
            superHeroe.setUniverse(foundUniverse);
        }

        Set<SuperPower> foundSuperPowers = new HashSet<>();
        for (SuperPower superPower : superHeroe.getSuperPowers()) {
            SuperPower foundSuperPower = superPowerRepository.findByName(superPower.getName());
            if (foundSuperPower != null) {
                foundSuperPowers.add(foundSuperPower);
            } else {
                foundSuperPowers.add(superPower);
            }
        }
        superHeroe.setSuperPowers(foundSuperPowers);

        return superHeroeRepository.save(superHeroe);
    }
    
    public List<SuperHeroe> findAll() {
        return superHeroeRepository.findAll();
    }
    
    public SuperHeroe findById(Long id) throws ResourceNotFoundException {
        return superHeroeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SuperHeroe not found for this id :: " + id));
    }
    
    public SuperHeroe updateSuperHeroe(Long superHeroeId, SuperHeroe superHeroeDetails) throws ResourceNotFoundException {
        SuperHeroe superHeroe = superHeroeRepository.findById(superHeroeId).orElseThrow(() -> new ResourceNotFoundException("SuperHeroe not found for this id :: " + superHeroeId));
        superHeroe.setName(superHeroeDetails.getName());
        superHeroe.setRealName(superHeroeDetails.getRealName());
        Universe foundUniverse = universeRepository.findByName(superHeroeDetails.getUniverse().getName());
        if (foundUniverse != null) {
            superHeroe.setUniverse(foundUniverse);
        } else {
            superHeroe.setUniverse(superHeroeDetails.getUniverse());
        }
        Set<SuperPower> foundSuperPowers = new HashSet<>();
        for (SuperPower superPower : superHeroeDetails.getSuperPowers()) {
            SuperPower foundSuperPower = superPowerRepository.findByName(superPower.getName());
            if (foundSuperPower != null) {
                foundSuperPowers.add(foundSuperPower);
            } else {
                foundSuperPowers.add(superPower);
            }
        }
        superHeroe.setSuperPowers(foundSuperPowers);        
        final SuperHeroe updatedSuperHeroe = superHeroeRepository.save(superHeroe);
        return updatedSuperHeroe;
    }
    
    public Map<String, Boolean> deleteSuperHeroe(Long superHeroeId) throws ResourceNotFoundException {
        SuperHeroe superHeroe = superHeroeRepository.findById(superHeroeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + superHeroeId));
        superHeroeRepository.delete(superHeroe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    public SuperHeroe killSuperHeroe(Long superHeroeId) throws ResourceNotFoundException {
    	SuperHeroe superHeroe = superHeroeRepository.findById(superHeroeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + superHeroeId));
    	superHeroe.kill();
    	return superHeroe;
    }
    
    public SuperHeroe reviveSuperHeroe(Long superHeroeId) throws ResourceNotFoundException {
    	SuperHeroe superHeroe = superHeroeRepository.findById(superHeroeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + superHeroeId));
    	superHeroe.revive();
    	return superHeroe;
    }    
}
