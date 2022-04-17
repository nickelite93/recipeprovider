package com.project.recipeprovider.response;

import com.project.recipeprovider.entity.Ingredient;
import com.project.recipeprovider.entity.Recipe;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
public class RecipeResponse {

    private String name;

    private String method;

    private List<Ingredient> ingredients;

    public RecipeResponse(Recipe recipe){
        this.name = recipe.getName();
        this.method = recipe.getMethod();
        this.ingredients = recipe.getIngredients();
    }


}
