package com.example.superheroes.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "universes")
public class Universo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "name", nullable = false, unique = true)
	private String name;
    
    @Column(name = "description", nullable = false)
	private String description;
    
    @OneToMany(mappedBy="universo", cascade = CascadeType.ALL)
    private Set<SuperHeroe> superHeroes = new HashSet<>();
    
    public Universo() {
        super();
    }
}
