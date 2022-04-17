package com.project.recipeprovider.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.recipeprovider.request.CreateRecipeRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Lob
    @Column( columnDefinition = "TEXT")
    private String method;

    @OneToMany(mappedBy = "recipe")
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(CreateRecipeRequest createRecipeRequest){
        this.name = createRecipeRequest.getName();
        this.method = createRecipeRequest.getMethod();
    }


}
