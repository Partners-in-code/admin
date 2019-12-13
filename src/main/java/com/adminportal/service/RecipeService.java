package com.adminportal.service;

import java.util.List;

import com.adminportal.domain.Recipe;

public interface RecipeService {
	Recipe save(Recipe recipe);
	List<Recipe> findAll();
	
}
