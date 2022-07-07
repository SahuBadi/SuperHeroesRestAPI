package com.example.superheroes.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.superheroes.exceptions.ResourceNotFoundException;
import com.example.superheroes.models.Universe;
import com.example.superheroes.repositories.UniverseRepository;

@Service
public class UniverseService {
	
    @Autowired
    private UniverseRepository universeRepository;
    
    public List<Universe> findAll() {
        return universeRepository.findAll();
    }
    
    public Universe getUniverseById(Long universeId) throws ResourceNotFoundException {
        Universe universe = universeRepository.findById(universeId).orElseThrow(() -> new ResourceNotFoundException("Universe not found for this id :: " + universeId));
        return universe;
    }
    
    public Universe createUniverse(Universe universe) {
        return universeRepository.save(universe);
    }
    
    public Universe updateUniverse(Long universeId, Universe universeDetails) throws ResourceNotFoundException {
        Universe universe = universeRepository.findById(universeId).orElseThrow(() -> new ResourceNotFoundException("Universe not found for this id :: " + universeId));
        universe.setName(universeDetails.getName());
        universe.setDescription(universeDetails.getDescription());
        final Universe updatedUniverse = universeRepository.save(universe);
        return updatedUniverse;
    }
    
    public Map<String, Boolean> deleteUniverse(Long universeId) throws ResourceNotFoundException {
        Universe universe = universeRepository.findById(universeId).orElseThrow(() -> new ResourceNotFoundException("Universe not found for this id :: " + universeId));
        universeRepository.delete(universe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
