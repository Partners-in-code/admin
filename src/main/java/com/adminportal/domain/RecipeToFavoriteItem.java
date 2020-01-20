package com.adminportal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RecipeToFavoriteItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_recipe")
	private Recipe recipe;

	@ManyToOne
	@JoinColumn(name = "id_favoriteItem")
	private FavoriteItem favoriteItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public FavoriteItem getFavoriteItem() {
		return favoriteItem;
	}

	public void setFavoriteItem(FavoriteItem favoriteItem) {
		this.favoriteItem = favoriteItem;
	}

}
