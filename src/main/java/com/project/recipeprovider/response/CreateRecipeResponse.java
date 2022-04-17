package com.project.recipeprovider.response;

import com.project.recipeprovider.entity.Recipe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRecipeResponse {

    private String name;

    public CreateRecipeResponse(Recipe recipe) {
        this.name = recipe.getName();
    }
}
