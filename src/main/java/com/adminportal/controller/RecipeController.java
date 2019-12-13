package com.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.adminportal.domain.Recipe;
import com.adminportal.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addRecipe(Model model) {
		Recipe recipe = new Recipe();
		model.addAttribute("recipe", recipe);
		return "addRecipe";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addRecipePost(@ModelAttribute("recipe") Recipe recipe, HttpServletRequest request) {
		recipeService.save(recipe);

		MultipartFile recipeImage = recipe.getRecipeImage();

		try {
			byte[] bytes = recipeImage.getBytes();
			String name = recipe.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/recipe/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:recipeList";
	}
	
	@RequestMapping("/recipeList")
	public String recipeList(Model model) {
		List<Recipe> recipeList = recipeService.findAll();
		model.addAttribute("recipeList",recipeList);
		
		return "recipeList";
		
	}

}
