package com.project.recipeprovider.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.recipeprovider.request.CreateIngredientRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.project.recipeprovider.entity.Recipe;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String quantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;

    public Ingredient(CreateIngredientRequest createIngredientRequest) {
        this.name = createIngredientRequest.getName();
        this.quantity = createIngredientRequest.getQuantity();
    }
}
