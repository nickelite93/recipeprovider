package com.project.recipeprovider;

import com.project.recipeprovider.entity.Recipe;
import com.project.recipeprovider.request.CreateRecipeRequest;
import com.project.recipeprovider.response.CreateRecipeResponse;
import com.project.recipeprovider.response.RecipeResponse;
import com.project.recipeprovider.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/recipe/")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @PostMapping(value = "/createNew1", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateRecipeResponse createRecipe(@RequestBody CreateRecipeRequest createRecipeRequest){
        Recipe recipe = recipeService.createRecipe(createRecipeRequest);
        return new CreateRecipeResponse(recipe);
    }

    @GetMapping("/getAll")
    public List<RecipeResponse> getAllRecipes() {
        List<RecipeResponse> recipes = recipeService.getAllRecipes();
        return recipes;
    }

    @GetMapping("/getByIngredient")
    public List<RecipeResponse> getRecipesWithIngredient(@RequestParam String ingredientName){
        List<RecipeResponse> recipes = recipeService.getRecipesByIngredient(ingredientName);
        return recipes;
    }

}
