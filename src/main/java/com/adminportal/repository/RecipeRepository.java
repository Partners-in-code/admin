package com.adminportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long>{
}
