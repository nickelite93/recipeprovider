package com.project.recipeprovider.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import java.util.List;

@Getter
@Setter
public class CreateRecipeRequest {

    private String name;

    @Lob
    private String method;

    private List<CreateIngredientRequest> requiredIngredients;
}
