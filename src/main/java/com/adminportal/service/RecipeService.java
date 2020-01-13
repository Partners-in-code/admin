package com.adminportal.service;

import java.util.List;

import com.adminportal.domain.Recipe;

public interface RecipeService {
	Recipe save(Recipe recipe);

	List<Recipe> findAll();

	Recipe findOne(Long id);

	void removeOne(Long id);
}
