package com.adminportal.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FavoriteItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Recipe recipe;

	@OneToMany(mappedBy = "favoriteItem")
	@JsonIgnore
	private List<RecipeToFavoriteItem> recipeToFavoriteItem;

	@ManyToOne
	@JoinColumn(name = "favorite_id")
	private Favorite favorite;

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

	public List<RecipeToFavoriteItem> getRecipeToFavoriteItem() {
		return recipeToFavoriteItem;
	}

	public void setRecipeToFavoriteItem(List<RecipeToFavoriteItem> recipeToFavoriteItem) {
		this.recipeToFavoriteItem = recipeToFavoriteItem;
	}

	public Favorite getFavorite() {
		return favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}

}
