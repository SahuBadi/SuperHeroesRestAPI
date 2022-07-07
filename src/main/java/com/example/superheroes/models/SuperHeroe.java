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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "superheroes")
public class SuperHeroe implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "name", nullable = false)
	private String name;
    
    @Column(name = "realname", nullable = false)
	private String realName;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="universe_id", nullable=false)
	private Universo universe;
    
    @JoinTable(
            name = "superheroe_superpowers",
            joinColumns = @JoinColumn(name = "superheroe_id"),
            inverseJoinColumns = @JoinColumn(name = "superpower_id"))
    Set<Poder> poderes = new HashSet<>();
    
    @Column(name="alive", columnDefinition = "boolean default true")
	private boolean alive;
    
	public SuperHeroe() { super(); }

}


