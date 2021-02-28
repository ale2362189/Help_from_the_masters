package com.promineotech.vaporVaultApi.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.vaporVaultApi.entity.Flavor;
import com.promineotech.vaporVaultApi.entity.Recipe;
import com.promineotech.vaporVaultApi.repository.FlavorRepository;
import com.promineotech.vaporVaultApi.repository.PercentRepository;
import com.promineotech.vaporVaultApi.repository.RecipeRepository;

;

@Service
public class RecipeService {

	private static final Logger logger = LogManager.getLogger(RecipeService.class);
	
	@Autowired
	private RecipeRepository repo;
	
	private FlavorRepository flavorRepo;
	
	private PercentRepository percentRepo;
	
	public Iterable<Recipe> getRecipes() {
		return repo.findAll();
	}
	
	public Recipe createRecipe(Recipe recipes) {
		// Postman not returning/adding flavors and percents with GET recipes 
		return repo.save(recipes);
		
		
	}
	
	public Recipe updateRecipe(Recipe recipes, Long id) {
		logger.info("Updating recipe {}" + recipes);
		Recipe oldRecipe = repo.findById(id)
					.orElseThrow(() -> new NoSuchElementException("Can't find recipe with id:" + id));
			oldRecipe.setFlavors(recipes.getFlavors());
			oldRecipe.setName(recipes.getName());
			oldRecipe.setPrice(recipes.getPrice());
			return repo.save(oldRecipe);
		
	}
	
	public void removeRecipe(Long id) throws Exception {
		try {
			repo.deleteById(id);			
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete product: " + id, e);
			throw new Exception("Unable to delete product.");
		}
	}
	
	
	/*
	 * Need help with how to write this method. It needs to take a Set of flavors
	 * and return a set of recipes that include all of the flavors in Set of flavors 
	 */
	
//	public Set<Long> findRecipeByFlavors(List<Long> flavorIds) {
//	  try {
//		  
//		  Set<Flavor> ingredients = flavorRepo.findAllById(flavorIds);
//		  // create hashset to hold recipe ids loop through all flavors, for each 
		  //	 flavor loop through recipes associated to get set of Long (ids)
//		  return
//		} catch (Exception e) {
//	logger.error("Exception occurred while trying to find recipes")
//	}
		
}
