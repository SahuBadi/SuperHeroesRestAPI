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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

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
    private Universe universe;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "superheroe_superpowers",
            joinColumns = @JoinColumn(name = "superheroe_id"),
            inverseJoinColumns = @JoinColumn(name = "superpower_id"))
    Set<SuperPower> superPowers = new HashSet<>();
    @Column(name="alive", columnDefinition = "boolean default true")
    private boolean alive;
    
	public SuperHeroe() { super(); }
	
	public void kill() {
		this.alive = false;
	}
	
	public void revive() {
		this.alive = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	public Set<SuperPower> getSuperPowers() {
		return superPowers;
	}

	public void setSuperPowers(Set<SuperPower> superPowers) {
		this.superPowers = superPowers;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}


