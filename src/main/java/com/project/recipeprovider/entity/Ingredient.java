package com.project.recipeprovider.entity;

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
    private int id;

    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
