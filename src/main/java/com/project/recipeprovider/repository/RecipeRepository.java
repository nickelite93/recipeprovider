package com.project.recipeprovider.repository;

import com.project.recipeprovider.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "SELECT * FROM Recipe LEFT JOIN Ingredient ON Recipe.id = Ingredient.recipe_id WHERE Ingredient.name LIKE %?1%", nativeQuery = true)
    public List<Recipe> FindAllWithDescriptionQuery(String ingredient);
}
