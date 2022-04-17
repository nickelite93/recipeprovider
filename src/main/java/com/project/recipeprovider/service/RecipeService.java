package com.project.recipeprovider.service;

import com.project.recipeprovider.entity.Ingredient;
import com.project.recipeprovider.entity.Recipe;
import com.project.recipeprovider.repository.IngredientRepository;
import com.project.recipeprovider.repository.RecipeRepository;
import com.project.recipeprovider.request.CreateIngredientRequest;
import com.project.recipeprovider.request.CreateRecipeRequest;
import com.project.recipeprovider.response.RecipeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    public Recipe createRecipe(CreateRecipeRequest createRecipeRequest) {

        Recipe recipe = new Recipe(createRecipeRequest);
        recipeRepository.save(recipe);
        List<Ingredient> ingredientList = new ArrayList<>();
        if(createRecipeRequest.getRequiredIngredients() != null){
            for(CreateIngredientRequest createIngredientRequest : createRecipeRequest.getRequiredIngredients()){
                Ingredient ingredient = new Ingredient(createIngredientRequest);
                ingredient.setRecipe(recipe);
                ingredientRepository.save(ingredient);
                ingredientList.add(ingredient);
            }
        }
        recipe.setIngredients(ingredientList);
        return recipe;
    }

    public List<RecipeResponse> getAllRecipes() {
        List<Recipe> listRecipes = recipeRepository.findAll();
        List<RecipeResponse> recipeResponses = new ArrayList<>();
        listRecipes.forEach(x -> recipeResponses.add(new RecipeResponse(x)));
        return recipeResponses;
    }

    public List<RecipeResponse> getRecipesByIngredient(String ingredientName) {
        List<Recipe> listRecipes = recipeRepository.FindAllWithDescriptionQuery(ingredientName);
        List<RecipeResponse> recipeResponses = new ArrayList<>();
        listRecipes.forEach(x -> recipeResponses.add(new RecipeResponse(x)));
        return recipeResponses;
    }
}
