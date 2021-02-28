package com.promineotech.vaporVaultApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "percent")
public class Percent {
	

	
	private Long id;
	private int percent;
	
	private Recipe recipe;
	
	@ManyToOne
	@JoinColumn(name = "recipeId")
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	@JsonIgnore
	private Flavor flavors;	
	
	
	@ManyToOne
	@JoinColumn(name = "flavorId")
	public Flavor getFlavors() {
		return flavors;
	}
	public void setFlavors(Flavor flavors) {
		this.flavors = flavors;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}

	
	
}
