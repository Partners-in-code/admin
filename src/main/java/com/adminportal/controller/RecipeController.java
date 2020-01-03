package com.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/recipeInfo")
	public String recipeInfo(@RequestParam("id") Long id, Model model) {
		Recipe recipe = recipeService.findOne(id);
		model.addAttribute("recipe", recipe);
		
		return "recipeInfo";
	}
	@RequestMapping("/updateRecipe")
	public String updateRecipe(@RequestParam("id") Long id, Model model) {
		Recipe recipe = recipeService.findOne(id);
		model.addAttribute("recipe", recipe);
		
		return "updateRecipe";
	}
	@RequestMapping(value="/updateRecipe", method=RequestMethod.POST)
	public String updateRecipePost(@ModelAttribute("recipe") Recipe recipe, HttpServletRequest request) {
		recipeService.save(recipe);
		
		MultipartFile recipeImage = recipe.getRecipeImage();
		
		if(!recipeImage.isEmpty()) {
			try {
				byte[] bytes = recipeImage.getBytes();
				String name = recipe.getId() + ".png";
				
				Files.delete(Paths.get("src/main/resources/static/image/recipe/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/recipe/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/recipe/recipeInfo?id="+recipe.getId();
	}
	@RequestMapping("/recipeList")
	public String recipeList(Model model) {
		List<Recipe> recipeList = recipeService.findAll();
		model.addAttribute("recipeList",recipeList);
		
		return "recipeList";
		
	}

}
