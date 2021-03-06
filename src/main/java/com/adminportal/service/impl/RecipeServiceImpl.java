package com.adminportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Recipe;
import com.adminportal.repository.RecipeRepository;
import com.adminportal.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;

	public Recipe save(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public List<Recipe> findAll() {
		return (List<Recipe>) recipeRepository.findAll();
	}

	public Recipe findOne(Long id) {
		return recipeRepository.findById(id).orElse(null);
	}

	public void removeOne(Long id) {
		recipeRepository.deleteById(id);
	}
}
