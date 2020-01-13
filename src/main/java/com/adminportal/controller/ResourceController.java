package com.adminportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminportal.service.RecipeService;

@RestController
public class ResourceController {

	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value="/recipe/removeList", method=RequestMethod.POST)
	public String removeList(
			@RequestBody ArrayList<String> recipeIdList, Model model
			){
		
		for (String id : recipeIdList) {
			String recipeId =id.substring(10);
			recipeService.removeOne(Long.parseLong(recipeId));
		}
		
		return "delete success";
	}
}
